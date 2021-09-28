package dev.bank.moneymatters.repositories;

import dev.bank.moneymatters.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<User, Integer> {

    User findUserByUserIdAndPassword(String userId, String password);
    User findUserByUserIdAndRoleRoleId(String userId);
    User findUserByUserId(String userId);


}