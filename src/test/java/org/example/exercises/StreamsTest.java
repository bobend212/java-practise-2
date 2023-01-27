package org.example.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.example.exercises.Streams.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamsTest {

    private Streams streams;

    @BeforeEach
    public void setUp() throws Exception {
        streams = new Streams();
    }

    @Test
    void countAgeOfAllStudentsTest() {
        assertEquals(streams.countAgeOfAllStudents(), 15);
    }

    @Test
    void getTheOldestStudentTest() {
        Student findStudent = streams.getTheOldestStudent();
        assertEquals(streams.getTheOldestStudent(), findStudent);
    }

    @Test
    void getStudentsWithNameStartingWithTest() {
        List<Student> findStudents = streams.getStudentsWithNameStartingWith('J');
        assertEquals(streams.getStudentsWithNameStartingWith('J'), findStudents);
    }

    @Test
    void getStudentsWithEvenAgeTest() {
        List<Student> findStudents = streams.getStudentsWithEvenAge();
        assertEquals(streams.getStudentsWithEvenAge(), findStudents);
    }

}
