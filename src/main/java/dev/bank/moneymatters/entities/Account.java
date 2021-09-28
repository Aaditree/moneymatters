package dev.bank.moneymatters.entities;

public class Account {
    private long AccountNumber;

    public long getAccountNumber()
    {

        // chose a Character random from this String
        String AlphaNumericString ="0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(11);

        for (int i = 0; i < 11; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return Long.parseLong(sb.toString());
    }

    public void setAccountNumber(long accountNumber) {
        AccountNumber = accountNumber;
    }
}
