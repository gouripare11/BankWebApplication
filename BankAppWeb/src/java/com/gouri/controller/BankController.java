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
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author LENOVO
 */
public class BankController extends HttpServlet {

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
            out.println("<title>Servlet BankController</title>");
            out.println("</head>");
            out.println("<body>");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String Account_Number = request.getParameter("Account_Number");
            String Customer_Name = request.getParameter("Customer_Name");

            UsersDAO ud = new UsersDAO();
            AccountBean ab = new AccountBean();
            ab = ud.loginCheck(username, password);
            HttpSession hs = request.getSession();
            if (ab != null) {
                hs.setAttribute("user", ab);
                response.sendRedirect("TransferForm.jsp");
            }

            String AccountNo = request.getParameter("AccountNo");
            String BeneficiaryAccountNo = request.getParameter("BeneficiaryAccountNo");
            String DateOfTransaction = request.getParameter("DateOfTransaction");
            float Amount = Float.parseFloat(request.getParameter("Amount"));
            BankDAO bd = new BankDAO();
            TransferBean tb = new TransferBean();
            tb.setTransactionID(bd.generateSequenceNumber());
            tb.setAccountNumber(AccountNo);
            tb.setBeneficiaryAccountNumber(BeneficiaryAccountNo);
            tb.setDateOfTransacton(DateOfTransaction);
            tb.setAmount(Amount);

            boolean r = bd.transferMoney(tb);
            if (r) {
                response.sendRedirect("TransferForm.jsp");
            } else {
                out.println("<center><h1><font color='red'>Money Transfer Failed !</font></h1></center>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}
