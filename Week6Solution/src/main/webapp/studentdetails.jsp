<%-- 
    Document   : studentdetails
    Created on : 23 Nov 2022, 20:33:35
    Author     : nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.week6solution.Student" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Full student details</h1>
        
         <%
       
    
         // Create an alias for the session variable, for easier use later
          ArrayList<Student> studentList = (ArrayList<Student>)session.getAttribute("students");
          
          // Read the student ID from the form
          String studentId = request.getParameter("studentId");
          
          // Loop through the students until we find one with that ID
          for(Student s: studentList)
          {
            if(s.getId().equals(studentId))
            {
                out.println(s);
            }
         }
         %>
         
    </body>
</html>
