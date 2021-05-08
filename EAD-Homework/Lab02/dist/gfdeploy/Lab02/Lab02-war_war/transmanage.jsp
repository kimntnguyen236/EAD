<%-- 
    Document   : transmanage
    Created on : Apr 9, 2021, 10:09:15 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            String currentBalance = request.getAttribute("currentBalance").toString();
        %>
        <h2>Welcome, <%=name%></h2>
        <h4>Current Balance : <%=currentBalance%></h4>
        <br/>
        <h1>All of Transactions</h1>
        <table border="1">
            <tr style="background-color: blue">
                <th>No.</th>
                <th>Withdraw</th>
                <th>Deposit</th>
                <th>Transaction Date</th>
                <th>Balance</th>
            </tr>
            <c:forEach items="${list}" var="items">
                <tr>
                    <td><c:out value="${items.getId()}"/></td>
                    <td><c:out value="${items.getWithdraw()}"/></td>
                    <td><c:out value="${items.getDeposit()}"/></td>
                    <td><c:out value="${items.getTransdate()}"/></td>
                    <td><c:out value="${items.getBalance()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
