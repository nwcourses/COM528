/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universityfortesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nick
 */
public class UniversityTest {
    private University university;
    Student student1, student2;
    
    
    
    @BeforeEach
    public void initUniversity() {
        university = new University("The University of Romsey");
        student1 = new Student("1", "Fred", "SE");
        student2 = new Student("2", "Jane", "Networks");
        university.enrolStudent(student1);
        university.enrolStudent(student2);
    }
    
    @Test
    public void testFindStudent() {
       
        assertEquals(university.findStudentById("1").getName(), "Fred");
    }
}
