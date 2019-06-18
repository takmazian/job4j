package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    private List<Student> studentList = new ArrayList<>();

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    void add(Student student) {
        studentList.add(student);
    }

    List<Student> getStudents() {
        return studentList;
    }
}
