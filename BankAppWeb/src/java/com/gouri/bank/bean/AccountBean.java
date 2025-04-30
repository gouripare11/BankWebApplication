/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gouri.bank.bean;

/**
 *
 * @author LENOVO
 */
public class AccountBean {
    private String Account_Number;
    private String Customer_Name;
    private float Balance;
    private int uid;
    private String userName;
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountBean() {
    }
    
    public AccountBean(String Account_Number, String Customer_Name, float Balance) {
        this.Account_Number = Account_Number;
        this.Customer_Name = Customer_Name;
        this.Balance = Balance;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String Account_Number) {
        this.Account_Number = Account_Number;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String Customer_Name) {
        this.Customer_Name = Customer_Name;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float Balance) {
        this.Balance = Balance;
    }

}
