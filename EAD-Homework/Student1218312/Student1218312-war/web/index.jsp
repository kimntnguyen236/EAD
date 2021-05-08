<%-- 
    Document   : index
    Created on : Apr 12, 2021, 9:16:55 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title Page</title>
    </head>
    <body>
        <h4>Search By Cost</h4>
        <form action="CameraServlet" method="GET">
            From Price: <input type="text" name="min" value="0" placeholder="Enter min price"/>
            To Price: <input type="text" name="max" value="0" placeholder="Enter max price"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <br/>
        <h4><a href="create.jsp">Create New</a></h4>
        <br/>
        <h1>Result</h1>
        <table border="2">
            <tr style="background-color: activeborder">
                <th>Camera ID</th>
                <th>Camera Name</th>
                <th>Camera Price</th>
                <th></th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.getCameraid()}"/></td>
                    <td><c:out value="${item.getCameraname()}"/></td>
                    <td><c:out value="${item.getCameraprice()}"/></td>
                    <td>
                        <a href="CameraServlet?action=delete&pcode=${item.getCameraid()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
