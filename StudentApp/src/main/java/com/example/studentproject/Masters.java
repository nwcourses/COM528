/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.studentproject;

/**
 *
 * @author nick
 */
public class Masters extends Student 
{
    public Masters(String idIn, String nameIn, String courseIn)
    {
        super(idIn, nameIn, courseIn);
    }
       
    @Override
    public String getGrade()
    {
        if (mark >= 70)
        {
            return "Distinction";
        } 
        else if (mark >= 60)
        {
            return "Merit";
        } 
        else if (mark >= 40) 
        {
            return "Pass";
        } 
        else 
        {
            return "Fail";
        }
    }
}
