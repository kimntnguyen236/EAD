<%-- 
    Document   : login
    Created on : Mar 10, 2021, 9:43:51 AM
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
    <center>
        <hr/><!-- comment -->
        <h1 >Login Page</h1>
        <form action="TabledithiServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter your name..."/>
                </div>
                    <br/><br/>
                    <div>
                    <input type="password" name="txtPass" placeholder="Enter your password..."/>
                </div>
                    <br/><br/>
                    <div>
                        <input type="submit" name="action" value="Sign in"/>
                </div>
            </div>
        </form>
        <hr/>
    </center>
    </body>
</html>
