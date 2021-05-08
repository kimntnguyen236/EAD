<%-- 
    Document   : index
    Created on : Apr 19, 2021, 9:43:49 AM
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
    <center>
        <h1 style="color: aquamarine">PATIENT SYSTEM MANAGEMENT</h1>
        <h1>List Movie</h1>
        <table border="1">
            <tr>
                <th>Patient ID</th>
                <th>Patient Name</th>
                <th>Patient Address</th>
                <th>Joined Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.getId()}"/></td>
                    <td><c:out value="${item.getName()}"/></td>
                    <td><c:out value="${item.getAddress()}"/></td>
                    <td><c:out value="${item.getJoindate()}"/></td>
                    <td><c:out value="${item.getStatus()}"/></td>
                    <td>
                        <a href="PatientServlet?action=Delete&id=${item.getId()}">Delete</a>
                        <a href="PatientServlet?action=Details&id=${item.getId()}">Details</a>
                        <a href="PatientServlet?action=Update&id=${item.getId()}">Update</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="createnew.jsp">Create New Patient</a>
    </center>
</body>
</html>
