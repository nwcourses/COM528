<%-- 
    Document   : addstudent
    Created on : 7 Nov 2022, 20:56:55
    Author     : nick
--%>

<%-- Version making use of the Student, Undergraduate and Masters classes --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.webexercise2.Student" %>
<%@page import="com.example.webexercise2.Undergraduate" %>
<%@page import="com.example.webexercise2.Masters" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Student details</h1>
    <%
    String sId = request.getParameter("studentId");
    String sName = request.getParameter("studentName");
    String sCourse = request.getParameter("studentCourse");
    String sMarkStr = request.getParameter("studentMark");
    String sType = request.getParameter("studentType");
    
    // Create either an Undergraduate or Masters depending on the student type
    Student student = null;
    if(sType.equals("Undergraduate"))
    {
        student = new Undergraduate(sId, sName, sCourse);
    }
    else
    {
        student = new Masters(sId, sName, sCourse);
    }
    // Convert the mark from String to double, as setMark() expects a double
    boolean success = student.setMark(Double.parseDouble(sMarkStr));
    if(success)
    {
    
    %>
    <p>
    Student details: <%=student%>
    </p>
    <%
    }
    else
    {
        // Note how you can output HTML from Java using out.println()
        // This might be useful if you want to avoid going into and out
        // of Java several times.
        out.println("<strong>Sorry, that mark was invalid. Please enter something between 0-100.</strong>");
    }

  
    %>
    
    </p>
    </body>
</html>
