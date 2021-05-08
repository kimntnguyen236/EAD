<%-- 
    Document   : index
    Created on : Apr 23, 2021, 11:27:35 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1>Staff List</h1>
        <table border="1">
            <tr>
                <th>Staff Code</th>
                <th>Staff Name</th>
                <th>Staff Email</th>
                <th>Department Name</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.getStaffid()}"/></td>
                    <td><c:out value="${item.getStaffname()}"/></td>
                    <td><c:out value="${item.getStaffemail()}"/></td>
                    <td><c:out value="${item.getDepartmentname()}"/></td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
