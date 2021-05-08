<%-- 
    Document   : login
    Created on : Apr 14, 2021, 11:50:50 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to TK Bank</h1>
        <h3>System Login</h3>
        <form action="BankServlet" method="POST">
            <input type="text" name="txtNo" placeholder="Enter account name"/>
            <input type="text" name="txtPincode" placeholder="Enter pincode"/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
