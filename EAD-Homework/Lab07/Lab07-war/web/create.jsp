<%-- 
    Document   : create
    Created on : Apr 19, 2021, 9:50:47 AM
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
        <h1>Create new Patient</h1>
        <form action="PatientServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtName" placeholder="Enter patient name ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtAddress" placeholder="Enter patient address ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtDate" placeholder="Enter join date ...." hidden="true"/>
                </div> <br/>
                <div>
                    <input type="text" name="txtStatus" placeholder="Enter status ...."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div> <br/>
            </div>
        </form>
    </body>
</html>
