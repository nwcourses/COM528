/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.example.studentproject;

/**
 *
 * @author nick
 */

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) 
    {
       
        Scanner scanner = new Scanner(System.in);
        String name, id, course, markString;
        double mark;
        for(int i=0; i<5; i++) 
        {
            System.out.println("Please enter the student ID: ");
            id = scanner.nextLine();
            System.out.println("Please enter the student name: ");
            name = scanner.nextLine();
            System.out.println("Please enter the student course: ");
            course = scanner.nextLine();
            
            // Set the student to null, as we don't know whether they will
            // be undergraduate or masters
            Student s;
            
            System.out.println("Undergraduate (u) or Masters (m)?");
            String studentType = scanner.nextLine();
            
            if(studentType.equals("m")) 
            {
                 s = new Masters(id, name, course);
            } 
            else 
            {
                 s = new Undergraduate(id, name, course);
            }
           
            System.out.println("Please enter the student mark: ");
            markString = scanner.nextLine();
            
            mark = Double.parseDouble(markString);
            
            s.setMark(mark);
            
            s.display();
            
        }
    }
}
