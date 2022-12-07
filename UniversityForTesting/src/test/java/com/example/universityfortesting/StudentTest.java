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

import com.example.universityfortesting.Student;

public class StudentTest {
    
    @Test
    public void testMark() {
        Student s = new Student("1", "Tom", "Computing");
        s.setMark(70.0);
        assertEquals(s.getGrade(), "First");
    }
}
