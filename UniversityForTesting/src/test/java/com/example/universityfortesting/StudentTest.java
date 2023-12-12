package com.example.universityfortesting;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nick
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;


import com.example.universityfortesting.Student;
import com.example.universityfortesting.University;

public class StudentTest {
    
    private University university;
    Student student1, student2;
    static University university2;
    
    @BeforeEach
    public void initUniversity() {
        university = new University("The University of Romsey");
        student1 = new Student("1", "Fred", "SE");
        student2 = new Student("2", "Jane", "Networks");
        university.enrolStudent(student1);
        university.enrolStudent(student2);
    }
    
    @BeforeAll
    public static void initBeforeAll() {
        university2 = new University("The University of Lyndhurst");
        Student student1 = new Student("1", "Fred", "SE");
        Student student2 = new Student("2", "Jane", "Networks");
        university2.enrolStudent(student1);
        university2.enrolStudent(student2);
    }
    
    @Test
    public void testMark() {
        Student s = new Student("1", "Tom", "Computing");
        s.setMark(70.0);
        assertEquals(s.getGrade(), "First");
    }
    
    @Test
    public void testFindStudent() {
       
        assertEquals(university2.findStudentById("1").getName(), "Fred");
    }
}
