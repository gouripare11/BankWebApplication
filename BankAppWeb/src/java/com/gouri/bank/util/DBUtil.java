/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gouri.bank.util;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class DBUtil {
    static Connection conn;
    
    public static Connection getDBConnection() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/march16";
        String un="root";
        String ps="pare1029";
        conn=DriverManager.getConnection(url,un,ps);
        System.out.println("--------------------------------Database Connectivity Success--------------------------------");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        getDBConnection();
    }
    
//    public StringtoString {
//        Retuns a String INSUFFICIENT FUNDS" "
//        + "The details about when it has to be thrown is "
//        + "given in the appropriate methods
//    }
}
