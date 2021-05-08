<%-- 
    Document   : transmanage
    Created on : Apr 14, 2021, 11:50:28 AM
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
        <%
            String name = session.getAttribute("aname").toString();
            String currentBalance = session.getAttribute("balance").toString();
        %>
        <h2>Welcome, <%=name%></h2>
        <h1>Tranfer within FAI Bank</h1>
        <h2>Your current balance: <%=currentBalance%></h2>
        <br/>
        <form action="BankServlet" method="POST">
            <input type="text" value="${name}" name="txtFrom" readonly="true"/><br/>
            <input type="text" name="txtTo" placeholder="Enter account to"/><br/>
            <input type="text" name="txtAmount" placeholder="Enter amount"/><br/>
            <textarea name="txtComment" rows="10" cols="10">Enter Comment</textarea> <br/>
            <input type="submit" value="Perform" name="action"/>
        </form>
    </body>
</html>
