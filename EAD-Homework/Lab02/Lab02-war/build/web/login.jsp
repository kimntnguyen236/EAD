<%-- 
    Document   : login
    Created on : Apr 9, 2021, 10:06:53 AM
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
        <form action="BankTransactionsServlet" method="POST">
            <input type="text" name="txtName" placeholder="Enter account name"/>
            <input type="text" name="txtPincode" placeholder="Enter pincode"/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
