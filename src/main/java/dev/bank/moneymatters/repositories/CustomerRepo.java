package dev.bank.moneymatters.repositories;

import dev.bank.moneymatters.entities.Customer;
import dev.bank.moneymatters.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

    Customer findCustomerByPanCard(String panCardNumber);

}

