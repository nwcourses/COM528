/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universityfortesting;

import java.util.ArrayList;

/**
 *
 * @author nick
 */
public class University 
{
    
    String name;
    
    private ArrayList<Student> students;
    
    public University(String n)
    {
        name = n;
        students = new ArrayList<>(); // initialise the ArrayList
    }
    
    public void enrolStudent(Student s)
    {
        students.add(s);
    }
    
    public Student findStudentById(String id)
    {
        // foreach loop - a more concise way of looping through an ArrayList
        // Each time the loop runs, currentStudent is the current student from
        // the ArrayList.
        for (Student currentStudent: students)
        {
            // Do the IDs match?
            if(currentStudent.getId().equals(id))
            {
                return currentStudent;
            }
        }
        // return null to indicate no student with that ID was found
        return null;
    }
    
    public ArrayList<Student> findStudentsByName(String name)
    {
        // Create an empty ArrayList of the matching students
        ArrayList<Student> foundStudents = new ArrayList<>();
        
        // foreach loop again
        for(Student currentStudent: students)
        {
            // If the name of the current student matches...
            if(currentStudent.getName().equals(name))
            {
                // Add it to the ArrayList of matching students.
                foundStudents.add(currentStudent);
            }
        }
        return foundStudents;
    }
}
