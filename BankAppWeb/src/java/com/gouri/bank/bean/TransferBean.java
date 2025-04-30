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
public class TransferBean {
    private int transactionID;
    private String AccountNumber;
    private String BeneficiaryAccountNumber;
    private String dateOfTransacton;
    private float amount;

    public TransferBean() {

    }

    public TransferBean(int transactionID, String fromAccountNumber, String toAccountNumber, String dateOfTransacton, float amount) {
        this.transactionID = transactionID;
        this.AccountNumber = fromAccountNumber;
        this.BeneficiaryAccountNumber = toAccountNumber;
        this.dateOfTransacton = dateOfTransacton;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String fromAccountNumber) {
        this.AccountNumber = fromAccountNumber;
    }

    public String getBeneficiaryAccountNumber() {
        return BeneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String toAccountNumber) {
        this.BeneficiaryAccountNumber = toAccountNumber;
    }

    public String getDateOfTransacton() {
        return dateOfTransacton;
    }

    public void setDateOfTransacton(String dateOfTransacton) {
        this.dateOfTransacton = dateOfTransacton;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}