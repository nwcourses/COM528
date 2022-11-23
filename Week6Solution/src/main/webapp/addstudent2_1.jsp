<%-- 
    Document   : addstudent
    Created on : 7 Nov 2022, 20:56:55
    Author     : nick
--%>

<%-- Version making use of the University in a session --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.week6solution.Student" %>
<%@page import="com.example.week6solution.Undergraduate" %>
<%@page import="com.example.week6solution.Masters" %>
<%@page import="com.example.week6solution.University" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Student details</h1>
    <%
        
        
    // Create the session variable if it doesn't exist already
    if(session.getAttribute("university") == null) 
    {
        session.setAttribute("university", new University("The University of Romsey"));
    }
    
    // Create an alias for the session variable, for easier use later
    University university = (University)session.getAttribute("university");
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
    
        // Enrol the student in the university
       university.enrolStudent(student);
    }
    else
    {
        // Note how you can output HTML from Java using out.println()
        // This might be useful if you want to avoid going into and out
        // of Java several times.
        out.println("<strong>Sorry, that mark was invalid. Please enter something between 0-100.</strong>");
    }

  
    %>
    <h2>Students added so far</h2>
    <%
    // Loop through students
    for(Student s: university.getStudentList()) 
    {
        %>
        Name: <%=s.getName()%>
        <!-- Create a form for each student, allowing the user to look up
             full details of the student. 
             Pass the student ID through a hidden field. -->
        <form method="get" action="studentdetails_1.jsp">
            <input type="hidden" name="studentId" value="<%=s.getId()%>" />
            <input type="submit" value="More details">
        </form>
        <br />
        <%
    }
    %>
    </p>
    </body>
</html>
