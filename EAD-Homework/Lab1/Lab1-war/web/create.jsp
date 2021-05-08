<%-- 
    Document   : create
    Created on : Apr 7, 2021, 11:47:29 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Title</title>
    </head>
    <body>
        <h1>Create New Programmer</h1>
        <form action="ProgrammerServlet" method="POST">
            <input type="text" name="txtName" placeholder="Enter name..."/>
            <input type="text" name="txtSkill" placeholder="Enter skill..."/>
            <input type="text" name="txtSalary" placeholder="Enter salary..."/>
            <input type="submit" value="Create" name="action"/>
        </form>
    </body>
</html>
