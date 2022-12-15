/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.week9solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nick
 */
public class StudentDao {

    private Connection conn;
    private String table;

    public StudentDao(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    // find a student with a given ID
    public Student findStudentById(long id) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("select * from " + table + " where id=?");
        pStmt.setLong(1, id);
        ResultSet rs = pStmt.executeQuery();

        // Is there a row? If so, next() will return true
        if (rs.next()) {
            // Create an Event object with the result
            return new Student(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getString("type")
            );
        }
        // return null if there were no matching rows
        return null;
    }

    // find all students with a given name
    // returns the students as an ArrayList
    public ArrayList<Student> findStudentsByName(String name) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement pStmt = conn.prepareStatement("select * from " + table + " where name=?");
        pStmt.setString(1, name);
        ResultSet rs = pStmt.executeQuery();

        // Loop through the results
        while (rs.next()) {
            // Create an Event object with each result and add it to the
            // ArrayList

            Student s = new Student(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getString("type")
            );
            s.setMark((double) rs.getInt("mark"));
            students.add(s);
        }
        return students;
    }

    // add a new student takes a Student object (which will contain a name,
    // a course, but NOT yet an ID) as a parameter and fills
    // in the ID attribute of the Student object with the ID allocated by 
    // the database. Also returns the allocated ID.
    public long addStudent(Student s) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into student(name, course, mark, type) values (?, ?, ?, ?)");
        pStmt.setString(1, s.getName());
        pStmt.setString(2, s.getCourse());
        pStmt.setInt(3, (int) s.getMark()); // cast the double to an int
        pStmt.setString(4, s.getType());

        int rowsAdded = pStmt.executeUpdate();
        long allocatedId = 0L;

        // Was a row added successfully?
        if (rowsAdded == 1) {
            // If so, get the keys added
            ResultSet rs = pStmt.getGeneratedKeys();

            // next() should return true, but check just in case
            if (rs.next()) {
                // get the allocated primary key
                allocatedId = rs.getLong(1);
            }
        }

        // Add the allocated ID to the event object and return the ID
        s.setId(allocatedId);
        return allocatedId;
    }

}
