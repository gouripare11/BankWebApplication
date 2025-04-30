<%-- 
    Document   : Login
    Created on : 29 Jun, 2024, 1:56:54 PM
    Author     : LENOVO



--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="Login.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="main">
        <nav class="nav">
            <ul type="none">
                <li><i class="fa-solid fa-building-columns" style="color: rgb(18, 18, 114); font-size: 50px;"></i></li>
                <li style="font-size: 28px; ">Welcome to our Banking System </li>
            </ul>
        </nav>
        
    </div>
    
    <div class="a">
        <div class="sub">
            <form action="Lcontroller" method="post">
                <p style="font-family: Verdana, Geneva, Tahoma, sans-serif; font-size: 23px;">Login</p>
                <table align="center" border="0" cellspacing="0" cellpadding="20">
                    <tr>
                        <td>UserName</td>
                        <td><input type="text" name="username" placeholder="username"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="password"></td>
                    </tr>
                </table><br><br>
                <button id="login">Login</button>
                <p>Don't have an account?<a href="CreateAccount.html">CreateNewAccount</a></p>
            </form>
        </div>
    </div>
</body>
</html>