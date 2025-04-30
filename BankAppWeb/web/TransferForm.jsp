<%-- 
    Document   : TransferForm
    Created on : 29 Jun, 2024, 2:25:25 AM
    Author     : LENOVO
--%>

<%@page import="com.gouri.bank.bean.AccountBean"%>
<%@page import="com.gouri.bank.bean.TransferBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Money</title>
        <link rel="stylesheet" href="TransferForm.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        
        <%
            AccountBean ab=(AccountBean) session.getAttribute("user");
        %>
        
    <nav class="nav">
        <ul type="none">
            <li><i class="fa-solid fa-building-columns" style="color: rgb(18, 18, 114); font-size: 50px;"></i></li>
            <li style="font-size: 28px; ">Welcome to menu page !</li>
            <li>
                <li id="l"><a href="Registration.html">Register</a></li>
                <li id="l"><a href="Login.html">Login</a></li>   
 
        </ul>
    </nav>

    <br><br>
    <h3 align="right" style="font-family: Verdana, Geneva, Tahoma, sans-serif; color: rgb(18, 18, 114);">Welcome <%=ab.getCustomer_Name()%></h3>
        
    <div class="a">
        <div class="sub">
            <form action="BController">
                <p align="center" style="font-size: 28px; font-family: Verdana, Geneva, Tahoma, sans-serif;">Money Transfer Form</p>
                <table cellspacing="0" cellpadding="0" border="0" align="center">
                    <tr>
                        <td>Account no.</td>
                        <td><input type="text" name="AccountNo" value=<%=ab.getAccount_Number()%>><br><br></td>
                    </tr>
                    <tr>
                        <td>Beneficiary Account no.</td>
                        <td><input type="text" name="BeneficiaryAccountNo" placeholder="beneficiary account no."><br><br></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td><input type="text" name="Amount" placeholder="amount"><br><br></td>
                    </tr>
                    <tr>
                        <td>Date of Transaction</td>
                        <td><input type="date" name="DateOfTransaction" placeholder="dd/mm/yyyy"><br><br></td>
                    </tr>
                </table><br><br>
                <center><button id="login">Transfer</button></center>
            </form>
        </div>
        <!--<a href="http://localhost:8084/BankAppWeb/History.jsp">Transaction History</a>-->
    </div>
</body>
</html>