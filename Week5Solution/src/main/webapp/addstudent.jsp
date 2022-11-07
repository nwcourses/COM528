<%-- 
    Document   : addstudent
    Created on : 7 Nov 2022, 20:56:55
    Author     : nick
--%>

<%-- Basic answer: read in form data and output it --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Student details</h1>
    <%
    String sName = request.getParameter("studentName");
    String sCourse = request.getParameter("studentCourse");
    String sMarkStr = request.getParameter("studentMark");
    String sType = request.getParameter("studentType");
    %>
    <p>
    Student name: <%=sName%> <br />
    Student course: <%=sCourse%> <br />
    Student mark: <%=sMarkStr%> <br />
    Student type: <%=sType%>
    </p>
    
    </p>
    </body>
</html>
