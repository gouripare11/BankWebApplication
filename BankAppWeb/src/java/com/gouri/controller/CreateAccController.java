/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gouri.controller;

import com.gouri.bank.bean.AccountBean;
import com.gouri.bank.bean.TransferBean;
import com.gouri.bank.dao.BankDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class CreateAccController extends HttpServlet {

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
            out.println("<title>Servlet CreateAccController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String accno=request.getParameter("accno");
            String cname=request.getParameter("cname");
            float bal=Float.parseFloat(request.getParameter("bal"));
            int uid=Integer.parseInt(request.getParameter("uid"));
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            BankDAO bd=new BankDAO();
            AccountBean ab=new AccountBean();
            TransferBean tb=new TransferBean();
            ab.setAccount_Number(accno);
            ab.setCustomer_Name(cname);
            ab.setBalance(bal);
            ab.setUid(uid);
            ab.setUserName(username);
            ab.setPassword(password);

            boolean r = bd.createAccount(ab);
            if (r) {
                out.println("<center><h1><font color='green'>Account Created Successfully !</font></h1></center>");
                out.println("<center><p><font size='5px'>Go to back to <a href='http://localhost:8084/BankAppWeb/Menu.jsp'>menu</a></font></p></center>");
            } else {
                out.println("<center><h1><font color='red'>Account Creation Failed !</font></h1></center>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
