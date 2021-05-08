
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="TabledithiServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter id ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtPass" placeholder="Enter password ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtName" placeholder="Enter Name ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtSalary" placeholder="Enter Salary ...."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div> <br/>
            </div>
        </form>
    </body>
</html>
