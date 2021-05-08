<%-- 
    Document   : update
    Created on : Apr 19, 2021, 10:54:13 AM
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
        <h1>Update Patient</h1>
        <form action="PatientServlet" method="POST">
            <div>
                <div>
                    <label>ID: </label>
                    <input type="text" name="txtID" value="${patient.getId()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" name="txtName" value="${patient.getName()}" placeholder="Enter new name..."/>
                </div> <br/>
                <div>
                    <label>Address:  </label>
                    <input type="text" name="txtAddress" value="${patient.getAddress()}" placeholder="Enter new address..."/>
                </div> <br/>
<!--                <div>
                    <label>Joined Date: </label>
                    <input type="text" name="txtDate" value="${patient.getJoindate()}" readonly="true"/>
                </div> <br/>-->
                <div>
                    <label>Status: </label>
                    <input type="text" name="txtStatus" value="${patient.getStatus()}" placeholder="Enter status..."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="UpdatePatient"/>
                </div> <br/>
            </div>
        </form>
        <a href="PatientServlet">Back to list</a>
    </body>
</html>
