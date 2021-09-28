package dev.bank.moneymatters.services;

import dev.bank.moneymatters.entities.Account;
import dev.bank.moneymatters.entities.Customer;
import dev.bank.moneymatters.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;


public class ManagerService {

    @Autowired
    private CustomerRepo cust;
    public Customer createNewCustomer(Customer newCust) {
        try {
            newCust = cust.save(newCust);
        }catch(Exception e){
            throw e;
        }
        return newCust;
    }

    public Account createNewAccount(int customerId) {
    return null;
    }

    public ResponseEntity<Object> verifyPanCard(String panCardNumber) {
        Customer customer = cust.findCustomerByPanCard(panCardNumber);
        HashMap<String,String> result = new HashMap<String, String>();
        if(customer != null)
        {
            result.put("message","Account exists");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else
        {
            result.put("message","Account doest not exists");
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }
}
