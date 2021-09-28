package dev.bank.moneymatters.controllers;

import dev.bank.moneymatters.services.AccCreationEmailService;
import dev.bank.moneymatters.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;
    @Autowired
    AccCreationEmailService accCreationEmailService;


    @PostMapping("user/login")
    public ResponseEntity<Object> verifyUserCredential(@RequestParam(required = true) String userId, @RequestParam(required = true) String password, @RequestParam (required = true)int roleId )
    {
        return userLoginService.verifyUserCredential(userId, password);
    }

    @PostMapping("user/email")
    public void sendMail(@RequestParam(required = true) String emailUserName,@RequestParam(required = true) String emailPassword, @RequestParam(required = true) String customerEmail)
    {
        accCreationEmailService.sendEmail(emailUserName,emailPassword,customerEmail);
    }

}