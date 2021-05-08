

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Account</h1>
        <form action="TabledithiServlet" method="POST">
            <div>
                <div>
                    <label>Account ID: </label>
                    <input type="text" name="txtID" value="${c.getTablecollum1()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label> Password:  </label>
                    <input type="password" name="txtPass" value="${c.getTablecollum2()}" placeholder="Enter new password..."/>
                </div> <br/>
                <div>
                    <label> Name: </label>
                    <input type="text" name="txtName" value="${c.getTablecollum3()}" placeholder="Enter Name ..."/>
                </div> <br/>
                <div>
                    <label> Salary: </label>
                    <input type="text" name="txtSalary" value="${c.getTablecollum5()}" placeholder="Enter salary..."/>
                </div> <br/>
             
                    <input type="submit" name="action" value="UpdateAccount"/>
                </div> <br/>
            </div>
        </form>
        <a href="TabledithiServlet">Back</a>
    </body>
</html>
