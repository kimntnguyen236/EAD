<%-- 
    Document   : index
    Created on : May 5, 2021, 9:31:03 AM
    Author     : WhiteMouse
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
        <h1>Find Salary</h1>
        <form action="CompanyServlet">
            <input type="text" name="min" value="0" placeholder="Enter min"/>
            <input type="text" name="max" value="0" placeholder="Enter max"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <h1>List of Employee</h1>
        <table border="1">
            <tr>
                <th>EmployeeCode</th>
                <th>EmployeeName</th>
                <th>EmployeePhone</th>
                <th>Salary</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                <td><c:out value="${item.getId()}"/></td>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getPhone()}"/></td>
                <td><c:out value="${item.getSalary()}"/></td>
                </tr>
            </c:forEach>
        </table>  
    </body>
</html>
