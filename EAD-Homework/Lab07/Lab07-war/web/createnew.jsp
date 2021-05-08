<%-- 
    Document   : createnew
    Created on : Apr 19, 2021, 11:16:18 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add New Patient</h1>
        <form action="PatientServlet" method="POST">
            <input type="text" name="txtName" placeholder="Enter patient name..."/><br/>
            <input type="text" name="txtAddress" placeholder="Enter patient address..."/><br/>
            <input type="text" name="txtDate" placeholder="Enter join date..."/><br/>
            Status : <input type="checkbox" name="cbStatus" value="true" checked="true"/> <br/>
            <input type="submit" name="action" value="CreateNew"/>
            
        </form>
    </body>
</html>
