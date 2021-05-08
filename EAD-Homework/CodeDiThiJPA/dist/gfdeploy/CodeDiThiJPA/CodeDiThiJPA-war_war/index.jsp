

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.html" %>
    <body>

    <center>
        <br/>

        <hr/>

        <a href="create.jsp" >Create New</a>
        <h3>Account List</h3>
        <form action="TabledithiServlet">
            <table border="1">
                <tr>
                    <th> Account ID </th>
                    <th> Name </th>
                    <th> Salary </th>
                    <th> Action </th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td> <c:out value="${item.getTablecollum1()}"/></td>
                        <td><c:out value="${item.getTablecollum3()}"/></td>
                        <td><c:out value="${item.getTablecollum5()}"/></td>
                        <td>
    
                            <a href="TabledithiServlet?action=delete&id=${item.getTablecollum1()}">Delete</a>
                            <a href="TabledithiServlet?action=details&id=${item.getTablecollum1()}">Details</a>
                            <a href="TabledithiServlet?action=getupdate&id=${item.getTablecollum1()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <hr/>
        <div>
            <form action="TabledithiServlet" method="POST">
                <input  type="text" name="uname" placeholder="Search by user name..."/>
                <input type="submit" name="action" value="Search"/>
            </form>
        </div>
        <hr/>
        <div>
            <form action="TabledithiServlet" method="POST">
                <label>Min: </label>
                <input  type="number" name="min" placeholder="Enter min salary..." required/>
                <label>Max: </label>
                <input  type="number" name="max" placeholder="Enter max salary..." required/>
                <input type="submit" name="action" value="SearchMinMax"/>
            </form>
        </div>
        <hr/>
        
    </center>
</body>
<%@include file="footer.html" %>
</html>
