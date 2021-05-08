<%-- 
    Document   : details
    Created on : Apr 23, 2021, 11:26:41 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Page</title>
    </head>
    <body>
        <h1>Profile Details</h1>
<!--        <div>
            <label>Staff Code: </label>
            <c:out value="${staff.getStaffid()}"/>
            <label>Staff Name: </label>
            <c:out value="${staff.getStaffname()}"/>
            <label>Staff Salary: </label>
            <c:out value="${staff.getSalary()}"/>
            <label>Staff Email: </label>
            <c:out value="${staff.getStaffemail()}"/>
        </div>-->
            
            <table border="1">
                <tr>
                    <th>Staff Code: </th>
                    <th>Staff Name: </th>
                    <th>Staff Salary: </th>
                    <th>Staff Email: </th>
                </tr>
                <c:forEach items="${staff}" var="item">
                    <tr>
                        <td><c:out value="${staff.getStaffid()}"/></td>
                        <td><c:out value="${staff.getStaffname()}"/></td>
                        <td><c:out value="${staff.getSalary()}"/></td>
                        <td><c:out value="${staff.getStaffemail()}"/></td>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
