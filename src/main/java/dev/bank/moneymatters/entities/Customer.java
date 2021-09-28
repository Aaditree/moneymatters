package dev.bank.moneymatters.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
    @SequenceGenerator(name="seq", initialValue=1000000, allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq")
    private int customerId;
    @Column
    private String panCard;
    @Column
    private	long aadharNumber;
    @Column
    private String name;
    @Column
    private String postalAddress;
    @Column
    private String email;
    @Column
    private LocalDate dob;
    @OneToOne(cascade=CascadeType.ALL)
    private User user;
    @Lob
    private byte[] panImg;
    @Lob
    private byte[] aadharImg;

    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer(int customerId, String panCard, long aadharNumber, String name, String postalAddress, String email,
                    LocalDate dob, User user, byte[] panImg, byte[] aadharImg) {
        super();
        this.customerId = customerId;
        this.panCard = panCard;
        this.aadharNumber = aadharNumber;
        this.name = name;
        this.postalAddress = postalAddress;
        this.email = email;
        this.dob = dob;
        this.user = user;
        this.panImg = panImg;
        this.aadharImg = aadharImg;
    }


    public byte[] getPanImg() {
        return panImg;
    }

    public void setPanImg(byte[] panImg) {
        this.panImg = panImg;
    }

    public byte[] getAadharImg() {
        return aadharImg;
    }

    public void setAadharImg(byte[] aadharImg) {
        this.aadharImg = aadharImg;
    }
    public void setDobFromString(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getPanCard() {
        return panCard;
    }
    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }
    public long getAadharNumber() {
        return aadharNumber;
    }
    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostalAddress() {
        return postalAddress;
    }
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}