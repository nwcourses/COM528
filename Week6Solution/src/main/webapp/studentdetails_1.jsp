<%-- 
    Document   : studentdetails
    Created on : 23 Nov 2022, 20:33:35
    Author     : nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.week6solution.Student" %>
<%@page import="com.example.week6solution.University" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Full student details - University version</h1>
        
         <%
       
    
         // Create an alias for the session variable, for easier use later
          University university = (University)session.getAttribute("university");
          
          // Read the student ID from the form
          String studentId = request.getParameter("studentId");
          
          // Now we can use University's findStudentById() method to find the student
          Student s = university.findStudentById(studentId);
          
          if(s != null) 
          {
               out.println(s);   
          }
          else
          {
               out.println("No student with that ID!");
          }          
        
         %>
         
    </body>
</html>
