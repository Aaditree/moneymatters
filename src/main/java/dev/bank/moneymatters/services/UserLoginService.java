package dev.bank.moneymatters.services;

import dev.bank.moneymatters.entities.User;
import dev.bank.moneymatters.repositories.UserLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class UserLoginService {

    private UserLoginRepo userrepo;

    public static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public User createNewUserCredentials() {
        String userId = getAlphaNumericString(7);
        String password = getAlphaNumericString(8);
        User newUser = new User(userId,password);
        return newUser;
    }

    public ResponseEntity<Object> verifyUserCredential(String userId, String password) {
        User user = userrepo.findUserByUserIdAndPassword(userId, password);
        User user1 = userrepo.findUserByUserIdAndRoleRoleId(userId);
        HashMap<String,String> result = new HashMap<String, String>();
        if (user != null && user1 != null) {
            result.put("message","Valid User");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else {
            result.put("message","Invalid User");
            return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
        }
    }

}
