/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gouri.bank.dao;

import com.gouri.bank.bean.AccountBean;
import com.gouri.bank.bean.TransferBean;
import com.gouri.bank.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class BankDAO {
    static Connection conn;
    
    public int generateSequenceNumber() {
        conn=DBUtil.getDBConnection();
        int i=(int)(Math.random()*100000);
        return i;
    }
    
    public ArrayList<TransferBean> find(String cno){
        TransferBean tb=new TransferBean();
        BankDAO bd=new BankDAO();
        conn=DBUtil.getDBConnection();
        ArrayList<TransferBean> l=new ArrayList<>();
        String sql="select * from transfer_table where Account_Number='"+cno+"'";
        try{
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                tb.setTransactionID(rs.getInt("Transaction_ID"));
                tb.setAccountNumber(rs.getString("Account_Number"));
                tb.setBeneficiaryAccountNumber(rs.getString("Beneficiary_Account_Number"));
                tb.setDateOfTransacton(rs.getString("Transaction_date"));
                tb.setAmount(rs.getFloat("Transaction_Amount"));
                l.add(tb);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public boolean createAccount(AccountBean ab) {
        boolean b=false;
        conn=DBUtil.getDBConnection();
        String sql="insert into account_table values('"+ab.getAccount_Number()+"','"+ab.getCustomer_Name()+"','"+ab.getBalance()+"','"+ab.getUid()+"','"+ab.getUserName()+"','"+ab.getPassword()+"')";
        
        try {
                Statement stmt=conn.createStatement();
                int rs=0;
                rs=stmt.executeUpdate(sql);
                if (rs>0) {
                    b=true;
                }
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public boolean validateAccount(String Account_Number) {
        boolean b=false;
        conn=DBUtil.getDBConnection();
        String sql="select Account_Number from account_table where Account_Number='"+Account_Number+"'";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
                b=true;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
    }
    
    public float findBalance(String Account_Number) {
        float bal=0f;
        conn=DBUtil.getDBConnection();
        String sql="select Balance from account_table where Account_Number='"+Account_Number+"'";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
                bal=rs.getFloat("Balance");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bal;
    }
    
    public boolean transferMoney(TransferBean tb) {
        boolean b=false;
        BankDAO bd=new BankDAO();
        conn=DBUtil.getDBConnection();
        int tid=bd.generateSequenceNumber();
        String sql="insert into transfer_table values('"+tid+"','"+tb.getAccountNumber()+"','"+tb.getBeneficiaryAccountNumber()+"','"+tb.getDateOfTransacton()+"','"+tb.getAmount()+"')";

        if(bd.validateAccount(tb.getAccountNumber()) && bd.validateAccount(tb.getBeneficiaryAccountNumber())) {
            float from=(float)(bd.findBalance(tb.getAccountNumber()));
            float to=(float)(tb.getAmount());
            if (from>to) {
                bd.updateBalance(tb.getAccountNumber(),from-to);
                bd.updateBalance(tb.getBeneficiaryAccountNumber(), (bd.findBalance(tb.getBeneficiaryAccountNumber())+to));
                try {
                    Statement stmt=conn.createStatement();
                    int rs=0;
                    rs=stmt.executeUpdate(sql);
                    if (rs>0) {
                        b=true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if (from<to) {
                bd.updateBalance(tb.getAccountNumber(),from+to);
                bd.updateBalance(tb.getBeneficiaryAccountNumber(), (bd.findBalance(tb.getBeneficiaryAccountNumber())-to));
                try {
                    Statement stmt=conn.createStatement();
                    int rs=0;
                    rs=stmt.executeUpdate(sql);
                    if (rs>0) {
                        b=true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                System.out.println("Insufficient Balance !");
            }
        }
        return b;
    }
    
    public boolean updateBalance(String from_Account_Number,float newBalance) {
        boolean b=false;
        conn=DBUtil.getDBConnection();
        String sql="update account_table set Balance='"+newBalance+"' where Account_Number='"+from_Account_Number+"'";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            int rs=0;
            rs=stmt.executeUpdate(sql);
            if(rs>0) {
                b=true;
            }
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static void main(String[] args) {
        BankDAO bd=new BankDAO();
//        TransferBean tb=new TransferBean();
//        tb.setTransactionID(bd.generateSequenceNumber());
//        tb.setAccountNumber("1234567890");
//        tb.setBeneficiaryAccountNumber("1234567891");
//        tb.setDateOfTransacton("08-06-2024");
//        tb.setAmount(100000f);
//        
//        boolean x1=bd.validateAccount("1234567890");
//        if(x1) {
//            System.out.println("VALID ACCOUNT NUMBER");
//        } else {
//            System.out.println("INVALID ACCOUNT NUMBER");
//        }
        
        //for money transfer
//        System.out.println(bd.transferMoney(tb));
        
        //for updating Balance
//        System.out.println(bd.updateBalance("1234567890",600000));
        
//        AccountBean ab=new AccountBean();
//        ab.setAccount_Number("1234567892");
//        ab.setCustomer_Name("Priya");
//        ab.setBalance(1600000);
//        ab.setUid(3);
//        ab.setUserName("Priya123");
//        ab.setPassword("1234");
//        
//        System.out.println(bd.createAccount(ab));

        
        ArrayList<TransferBean> l=bd.find("1234567890");
        for(TransferBean tb:l) {
           
                System.out.println("<td>"+tb.getTransactionID()+"</td>");
                 System.out.println("<td>"+tb.getAccountNumber()+"</td>");
                 System.out.println("<td>"+tb.getBeneficiaryAccountNumber()+"</td>");
                 System.out.println("<td>"+tb.getDateOfTransacton()+"</td>");
                System.out.println("<td>"+tb.getAmount()+"</td>");
          
        }
        
    }
    
}
