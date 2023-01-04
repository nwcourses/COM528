/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.week9solution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.*;

/**
 *
 * @author nick
 */
public class StudentDaoTest {

    @Test
    public void testFindStudentById() throws Exception {

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/home/nick/university.db");
            StudentDao dao = new StudentDao(conn, "student");
            Student s = new Student(0, "Charles Smith", "Chemistry", "undergraduate");
            long id = dao.addStudent(s);
            assertNotNull(dao.findStudentById(id));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Test
    public void testNonExistentId() throws Exception {
        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/home/nick/university.db");
            StudentDao dao = new StudentDao(conn, "student");
            Student s = new Student(0, "Charles Jones", "Computing", "undergraduate");
            long id = dao.addStudent(s);
            assertNull(dao.findStudentById(id + 1)); // will be null as the auto-allocated ID is the greatest so far
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
