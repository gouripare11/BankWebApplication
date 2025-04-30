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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class History extends HttpServlet {

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
            out.println("<title>Servlet History</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1' cellspacing='0' cellpadding='10' align='center'>");
            out.println("<tr>");
                out.println("<th>Transaction_ID</th>");
                out.println("<th>Account no.</th>");
                out.println("<th>Beneficiary Account no.</th>");
                out.println("<th>Date of Transaction</th>");
                out.println("<th>Amount</th>");
            out.println("</tr>");
            HttpSession hs=request.getSession();
            AccountBean b=(AccountBean)hs.getAttribute("user");
            
        BankDAO bd=new BankDAO();
        ArrayList<TransferBean> l=bd.find("1234567890");
        for(TransferBean tb:l) {
            out.println("<tr>");
                out.println("<td>"+tb.getTransactionID()+"</td>");
                out.println("<td>"+tb.getAccountNumber()+"</td>");
                out.println("<td>"+tb.getBeneficiaryAccountNumber()+"</td>");
                out.println("<td>"+tb.getDateOfTransacton()+"</td>");
                out.println("<td>"+tb.getAmount()+"</td>");
            out.println("</tr>");
        }
            
        out.println("</table>");
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
