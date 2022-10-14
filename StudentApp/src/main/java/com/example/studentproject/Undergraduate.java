/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.studentproject;

/**
 *
 * @author nick
 */
public class Undergraduate extends Student 
{
    
    public Undergraduate(String idIn, String nameIn, String courseIn)
    {
        super(idIn, nameIn, courseIn);
    }
    
    @Override
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
}
