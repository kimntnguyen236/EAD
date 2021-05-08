<%-- 
    Document   : index
    Created on : Apr 7, 2021, 10:14:16 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Title</title>
    </head>
    <body>
        <h1>List Programmers</h1>
        <h3><a href="create.jsp">Create New</a></h3>
        <form action="ProgrammerServlet" method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Skill</th>
                    <th>Salary</th>
                </tr>
                <c:forEach items="${list}" var="items">
                    <tr>
                        <td><c:out value="${items.getId()}"/></td>
                        <td><c:out value="${items.getName()}"/></td>
                        <td><c:out value="${items.getSkill()}"/></td>
                        <td><c:out value="${items.getSalary()}"/></td>
                    </tr>
                </c:forEach>


            </table>
        </form>
    </body>
</html>
