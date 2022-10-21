/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.example.week3solution;

/**
 *
 * @author nick
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Week3SolutionApp 
{
    public static void main(String[] args) 
    {
        University university = new University("The University of Romsey");
        
        Scanner scanner = new Scanner(System.in);
        
        String option = "";
        int counter = 1;
        
        // Loop until the option equals "4" (quit)
        while(! option.equals("4"))
        {
            System.out.println("1. Add a student");
            System.out.println("2. Find student by ID");
            System.out.println("3. Find students by name");
            System.out.println("4. Quit");
            
            System.out.println("Your choice: "); // a prompt
            
            option = scanner.nextLine();
            
            // "switch" is a more concise way of doing an "if" statement with
            // discrete values.
            
            switch(option)
            {
                // Did the user choose "1"?
                case "1":
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("Course:");
                    String course = scanner.nextLine();
                    System.out.println("Mark:");
                    String markStr = scanner.nextLine();
                    double mark = Double.parseDouble(markStr);
                    
                    // Convert the counter to a string, to use as an ID
                    // String.valueOf() is the opposite to Integer.parseInt(), etc:
                    // it converts a number to a string
                    // IDs will therefore take the form S1, S2, etc
                    String id = "S" + String.valueOf(counter);
                    
                    // Assume it's an undergraduate
                    // You could enhance this with an "if" statement to create
                    // a Masters student if the user chooses
                    Student student = new Undergraduate(id, name, course);
                    
                    // Set the mark
                    student.setMark(mark);
                    
                    // Enrol the student
                    university.enrolStudent(student);
                    
                    // Increase the counter for the next student ID
                    counter++;
                    
                    break; // ends the switch case
                    
                // Did the user choose "2"?
                case "2":
                    System.out.println("Enter the student ID:");
                    String searchId = scanner.nextLine();
                    Student foundStudent = university.findStudentById(searchId);
                    
                    // If no results, null is returned
                    if(foundStudent == null)
                    {
                        System.out.println("Sorry, no student with that ID!");
                    }
                    else
                    {
                        foundStudent.display();
                    }
                    break;
                    
                // Did the user choose "3"
                case "3":
                    System.out.println("Enter the student name:");
                    String searchName = scanner.nextLine();
                    ArrayList<Student> foundStudents = university.findStudentsByName(searchName);
                    
                    // If no matches, the array list will be empty
                    if(foundStudents.isEmpty())
                    {
                        System.out.println("Sorry, no students with that name!");
                    }
                    else
                    {
                        // Loop through all found students
                        // Use foreach loop - see the University class
                        
                        for(Student s: foundStudents)
                        {
                            s.display();
                        }
                    }
                    break;
            }
        }
    }
}
