<%-- 
    Document   : index
    Created on : Apr 19, 2021, 8:46:32 AM
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
        <h1 style="color: aquamarine">MOVIE SYSTEM MANAGEMENT</h1>
        <h1>List Movie</h1>
        <table border="1">
            <tr>
                <th>Movie ID</th>
                <th>Title</th>
                <th>Relase Date</th>
                <th>Director</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                <td><c:out value="${item.getMovieid()}"/></td>
                <td><c:out value="${item.getTitle()}"/></td>
                <td><c:out value="${item.getRelasedate()}"/></td>
                <td><c:out value="${item.getDirector()}"/></td>
                </tr>
            </c:forEach>
        </table>
        </center>
</body>
</html>
