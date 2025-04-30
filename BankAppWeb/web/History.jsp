<%-- 
    Document   : History
    Created on : 11 Jul, 2024, 3:45:49 PM
    Author     : LENOVO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.gouri.bank.bean.TransferBean"%>
<%@page import="com.gouri.bank.dao.BankDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="10" align="center">
            <tr>
                <th>Transaction_ID</th>
                <th>Account no.</th>
                <th>Beneficiary Account no.</th>
                <th>Date of Transaction</th>
                <th>Amount</th>
            </tr>
            
            
            <%
                BankDAO bd = new BankDAO();
                ArrayList<TransferBean> l = bd.find();


            %>
            <tr>
                <td><%=tb.getTransactionID()%></td>
                <td><%=tb.getAccountNumber()%></td>
                <td><%=tb.getBeneficiaryAccountNumber()%></td>
                <td><%=tb.getDateOfTransacton()%></td>
                <td><%=tb.getAmount()%></td>
            </tr>
            <%
                }
            %>
        </table>
        
    </body>
</html>

    </body>
</html>