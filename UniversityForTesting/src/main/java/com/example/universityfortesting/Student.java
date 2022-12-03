/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universityfortesting;

/**
 *
 * @author nick
 */
public class Student 
{
    protected String id, name, course;
    protected double mark;
    
    public Student(String idIn, String nameIn, String courseIn) 
    {
        id = idIn;
        name = nameIn;
        course = courseIn;
    }
    
    public boolean setMark(double newMark) 
    {
        if(newMark >= 0 && newMark <= 100) 
        {
            mark = newMark;
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    public String getId() 
    {
        return id;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public String getCourse() 
    {
        return course;
    }
    
    public double getMark() 
    {
        return mark;
    }

      public String getGrade() 
    {
        if (mark >= 70) 
        {
            return "First";
        } 
        else if (mark >= 60) 
        {
            return "2/1";
        } 
        else if (mark >= 50)
        {
            return "2/2";
        } 
        else if (mark >= 40) 
        {
            return "Third";
        } 
        else 
        {
            return "Fail";
        }
    }
    
    public String toString()
    {
        return "ID: " + id + " Name: " + name + " Course: " + course + " Grade: " + this.getGrade();
    }
    
}
