<%-- 
    Document   : update
    Created on : Apr 12, 2021, 10:31:15 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Project</h1>
        <form action="ProjectManage" method="POST">
            <input type="text" name="txtCode" value="${p.getProjectcode()}" readonly="true"/>
            <input type="text" value="${p.getProjectname()}" readonly="true"/>
            <input type="text" value="${p.getDuration()}" readonly="true"/>
            <input type="text" name="txtCost" value="${p.getCost()}"/>
            <input type="submit" value="Update" name="action"/>
        </form>
    </body>
</html>
