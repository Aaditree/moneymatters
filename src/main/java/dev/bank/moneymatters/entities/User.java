package dev.bank.moneymatters.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
    @Id
    private String userId;
    private String password;
    private boolean isFirstTime;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }
    public void setFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }
    public User(String userId, String password) {
        super();
        this.userId = userId;
        this.password = password;
        this.isFirstTime = true;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }






}