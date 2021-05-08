<%-- 
    Document   : index
    Created on : Apr 13, 2021, 9:48:22 AM
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
        <h1>Country Manage</h1>
        
        <h3>Create New City</h3>
        <form action="CountryServlet" method="POST">
            <input type="text" name="txtName" placeholder="Enter City Name..."/>
            <input type="text" name="txtPop" placeholder="Enter City Population..."/>
            <input type="text" name="txtZipCode" placeholder="Enter City Zip Code..."/>
            <select name="cbx">
                <option>--- Country Name ---</option>
                <c:forEach items="${requestScope.listCountry}" var="i">
                    <option value="${i.getCountryname()}">${i.getCountryname()}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Create" name="action"/>
        </form>
        
        <hr/>
        <h3>Search</h3>
        <form action="CountryServlet" method="GET">
            <select name="CountryNamecbx">
                <option value="all">--- Country Name ---</option>
                <c:forEach items="${requestScope.listCountry}" var="i">
                    <option value="${i.getCountryname()}">${i.getCountryname()}</option>
                </c:forEach>
            </select>
            <select name="CityNamecbx">
                <option value="ctall">--- City Name ---</option>
                <c:forEach items="${requestScope.listCity}" var="i">
                    <option value="${i.getCityname()}">${i.getCityname()}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Filter" name="action"/>
        </form>
        
        <hr/>
        <h3>List</h3>
        <table border="1">
            <tr style="color: blue; background-color: aliceblue" >
                    <th>City Name</th>
                    <th>Population</th>
                    <th>Zip Code</th>
                    <th>Country Name</th>
                    <th>Country Code</th>
                    <th>Language Code</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <tr>
                        <td><c:out value="${item.getCityname()}"/></td>
                        <td><c:out value="${item.getPopulation()}"/></td>
                        <td><c:out value="${item.getZipcode()}"/></td>
                        <td><c:out value="${item.getCountryname()}"/></td>
                        <td><c:out value="${item.getCountrycode()}"/></td>
                        <td><c:out value="${item.getLanguagecode()}"/></td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
