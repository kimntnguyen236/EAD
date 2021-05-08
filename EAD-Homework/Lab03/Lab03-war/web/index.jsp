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
        <h3>Visitor number: ${requestScope.visitor}</h3>
        <h5>Search By Cost</h5>
        <form action="ProjectManage" method="GET">
            Min Cost: <input type="text" name="min" value="0" placeholder="Enter min cost"/>
            Max Cost: <input type="text" name="max" value="0" placeholder="Enter max cost"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <h5>Search By Name</h5>
        <form action="ProjectManage" method="GET">
            Project Name: <input type="text" name="txtName" placeholder="Enter project name"/>
            <input type="submit" name="action" value="Filter"/>
        </form>
        <h1>List of Projects</h1>
        <table border="2">
            <tr style="background-color: activeborder">
                <th>Project Code</th>
                <th>Project Name</th>
                <th>Duration</th>
                <th>Cost</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.getProjectcode()}"/></td>
                    <td><c:out value="${item.getProjectname()}"/></td>
                    <td><c:out value="${item.getDuration()}"/></td>
                    <td><c:out value="${item.getCost()}"/></td>
                    <td>
                        <a href="ProjectManage?action=delete&pcode=${item.getProjectcode()}">Delete || </a>
                        <a href="ProjectManage?action=getupdate&pcode=${item.getProjectcode()}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h4><a href="create.jsp">Create New</a></h4>
    </body>
</html>
