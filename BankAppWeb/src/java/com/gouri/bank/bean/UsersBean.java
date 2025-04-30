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
public class UsersBean {
    private int uid;
    private String name;
    private String userName;
    private String password;

    public UsersBean() {
    }

    public UsersBean(int uid, String name, String userName, String password) {
        this.uid = uid;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
      
}
