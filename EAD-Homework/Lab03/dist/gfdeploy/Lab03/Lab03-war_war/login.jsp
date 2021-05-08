<%-- 
    Document   : login
    Created on : May 6, 2021, 7:17:43 PM
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
        <h1 style="color: aqua">L O G I N  P A G E</h1>
        <form action="ProjectManage" method="POST">
            <div>
                <div>
                    <input type="text" name="txtCode" placeholder="Enter your Code ..."/>
                </div><br/>
                <div>
                    <input type="password" name="txtName" placeholder="Enter your Project Name ..."/>
                </div><br/><br/>
                <div>
                    <input type="submit" value="Login" name="action"/>
                </div>
            </div>
        </form>
    </body>
</html>
