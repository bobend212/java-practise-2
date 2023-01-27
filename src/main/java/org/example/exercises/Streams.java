package org.example.exercises;

import java.util.List;

public class Streams {

    class Student {
        public int age;
        public String name;

        public Student(final int age, final String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    List<Student> students = List.of(
            new Student(1, "Jan"),
            new Student(2, "Janusz"),
            new Student(3, "Michal"),
            new Student(4, "Piotr"),
            new Student(5, "Pawel"));

    public Integer countAgeOfAllStudents() {
        return students.stream().mapToInt(student -> student.age).sum();
    }

    public Student getTheOldestStudent() {
        var maxAge = students.stream().map(student -> student.age).max(Integer::compareTo).orElseThrow();
        return students.stream()
                .filter(student -> student.age == maxAge).findFirst().orElseThrow();
    }

    public List<Student> getStudentsWithNameStartingWith(char letter) {
        return students.stream().filter(student -> student.name.startsWith(Character.toString(letter))).toList();
    }

    public List<Student> getStudentsWithEvenAge() {
        return students.stream().filter(student -> student.age % 2 == 0).toList();
    }
}
