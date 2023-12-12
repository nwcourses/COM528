/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.week9solution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.sql.*;

/**
 *
 * @author nick
 */
public class StudentDaoTest {

    static Connection conn = null;

    @BeforeAll
    public static void setupDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/home/nick/university.db");
            StudentDao dao = new StudentDao(conn, "student");
            Student s = new Student(0, "Charles Smith", "Chemistry", "undergraduate");
            long id = dao.addStudent(s);
            assertNotNull(dao.findStudentById(id));
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
    @AfterAll
    public static void teardownDb() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Test
    public void testFindStudentById() throws Exception {

        try {
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

        StudentDao dao = new StudentDao(conn, "student");
        Student s = new Student(0, "Charles Jones", "Computing", "undergraduate");
        long id = dao.addStudent(s);
        assertNull(dao.findStudentById(id + 1)); // will be null as the auto-allocated ID is the greatest so far
    }
}
