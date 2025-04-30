/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.ś
 */
package com.gouri.bank.dao;

import com.gouri.bank.bean.AccountBean;
import static com.gouri.bank.dao.BankDAO.conn;
import com.gouri.bank.util.DBUtil;
import com.gouri.bank.bean.UsersBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class UsersDAO {
    static Connection conn;
    public int registerUser(UsersBean ub){
        int r=0;
        conn=DBUtil.getDBConnection();
        String sql="insert into account_table values(?,?,?)";
        try {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,ub.getUid());
            pstmt.setString(2,ub.getUserName());
            pstmt.setString(3,ub.getPassword());
            r=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).
            log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public AccountBean loginCheck(String un,String ps){
        System.out.println("Login check is called");
        conn=DBUtil.getDBConnection();
        String sql="select * from account_table where username=? and password=?";
        AccountBean ab=new AccountBean();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, un);
            pstmt.setString(2, ps);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
               
                ab.setAccount_Number(rs.getString("Account_Number"));
                ab.setCustomer_Name(rs.getString("Customer_Name"));
                ab.setBalance(rs.getFloat("Balance"));
            }
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsersDAO.class.getName()).
                log(Level.SEVERE, null, ex);
            }
        return ab;
    }
    
    public static void main(String[] args) {

        UsersBean u=new UsersBean();
        AccountBean ab=new AccountBean();

        ab.setAccount_Number("Account_Number");
        ab.setCustomer_Name("Customer_Name");
//        
//    u.setName("Gouri");
//    u.setUserName("Gouri123");
//    u.setPassword("1111");
//    u.setUid(1);
////
    UsersDAO ud=new UsersDAO();
//    int r=ud.registerUser(u);
//    if(r>0){
//        System.out.println("Registration Success");
//    }else{
//        System.out.println("Registration Fail");
//    }
    
    ab=ud.loginCheck("Reddy123","1234");
        System.out.println("Name : "+ab.getCustomer_Name());
        System.out.println("Balance : "+ab.getBalance());
        System.out.println("Account No. : "+ab.getAccount_Number());
        
        
    if(ab!=null){
        System.out.println("Login Success");
    }else{
        System.out.println("Login Fail");
    }
    }
}
