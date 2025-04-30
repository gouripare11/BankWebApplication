<%-- 
    Document   : Menu
    Created on : 27 Jun, 2024, 4:18:27 PM
    Author     : LENOVO
--%>

<%@page import="com.gouri.bank.bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Menu.css">
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
                <li id="l"><a href="CreateAccount.html">Register</a></li>
                <li id="l"><a href="Login.jsp">Login</a></li>
            
            
        </ul>
    </nav>
        <br><br>
    <h3 align="right" style="font-family: Verdana, Geneva, Tahoma, sans-serif; color: rgb(18, 18, 114);">Welcome <%=ab.getCustomer_Name()%></h3>
    
    <div class="a">
        <div class="a1">
            <a href="http://localhost:8084/BankAppWeb/CreateAccount.html" id="la"><font size="5px">Create New Account</font></a>
        </div>
        <div class="a2">
            <a href="http://localhost:8084/BankAppWeb/TransferForm.jsp" id="la"><font size="5px">Transfer Money</font></a>
        </div>
        <div class="a3">
                <a href="http://localhost:8084/BankAppWeb/CheckBal.jsp" id="la"><font size="5px">Check Balance</font></a>
        </div>
    </div>
        
</body>
</html>
