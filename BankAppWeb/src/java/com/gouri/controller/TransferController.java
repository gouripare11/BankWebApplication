/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gouri.controller;

import com.gouri.bank.bean.AccountBean;
import com.gouri.bank.bean.TransferBean;
import com.gouri.bank.dao.BankDAO;
import com.gouri.bank.dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class TransferController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TransferController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String Account_Number=request.getParameter("Account_Number");
            String Customer_Name=request.getParameter("Customer_Name");
            
            UsersDAO ud=new UsersDAO();
            TransferBean tb=new TransferBean();
            
            AccountBean ab = new AccountBean();
            ab = ud.loginCheck(username, password);
            HttpSession hs = request.getSession();
            if (ab != null) {
                hs.setAttribute("user", ab);
                response.sendRedirect("TransferForm.jsp");
            } else {
                out.println("<h1><font color='red'>Login Fail !</font></h1>");
            }
            String AccountNo = request.getParameter("AccountNo");
            String BeneficiaryAccountNo = request.getParameter("BeneficiaryAccountNo");
            String DateOfTransaction = request.getParameter("DateOfTransaction");
            float Amount = Float.parseFloat(request.getParameter("Amount"));
            BankDAO bd = new BankDAO();
            tb.setTransactionID(bd.generateSequenceNumber());
            tb.setAccountNumber(AccountNo);
            tb.setBeneficiaryAccountNumber(BeneficiaryAccountNo);
            tb.setDateOfTransacton(DateOfTransaction);
            tb.setAmount(Amount);

            boolean r = bd.transferMoney(tb);
            if (r) {
                out.println("<center><h1><font color='green'>Money Transfer Success !</font></h1></center>");
                out.println("<center><p><font size='5px'>Go to <a href='http://localhost:8084/BankAppWeb/Menu.jsp'>menu</a></font></p></center>");
            } else {
                out.println("<center><h1><font color='red'>Money Transfer Failed !</font></h1></center>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}

