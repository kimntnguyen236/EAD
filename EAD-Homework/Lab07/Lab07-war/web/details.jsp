<%-- 
    Document   : details
    Created on : Apr 19, 2021, 10:21:41 AM
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
        <h1>Patient Details</h1>
        <form action="PatientServlet" method="GET">
            <div>
                <div>
                    <label>ID: </label>
                    <input type="text" value="${patient.getId()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Name: </label>
                    <input type="text" value="${patient.getName()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Address: </label>
                    <input type="text" value="${patient.getAddress()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Joined Date: </label>
                    <input type="text" value="${patient.getJoindate()}" readonly="true"/>
                </div> <br/>
                <div>
                    <label>Status: </label>
                    <input type="text" value="${patient.getStatus()}" readonly="true"/>
                </div> <br/>
            </div>
        </form>
        <a href="PatientServlet">Back to list</a>
    </body>
</html>
