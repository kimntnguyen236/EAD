<%-- 
    Document   : login
    Created on : Apr 23, 2021, 11:26:50 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1 style="color: aqua">Staff Login</h1>
        <form action="CompanyServlet" method="POST">
            <input type="text" name="txtID" placeholder="Enter your id"/>
            <input type="text" name="txtPass" placeholder="Enter your password"/>
            <input type="submit" value="Login" name="action"/>
        </form>
    </body>
</html>
