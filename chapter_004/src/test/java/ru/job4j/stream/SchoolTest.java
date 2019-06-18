package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SchoolTest {

    private List<Student> students = new ArrayList<>();

    @Test
    public void getListClassA() {
        School school = new School();
        Student student1 = new Student(70);
        Student student2 = new Student(45);
        Student student3 = new Student(85);
        Student student4 = new Student(60);
        Student student5 = new Student(95);
        Student student6 = new Student(65);
        List<Student> checkList = new ArrayList<>();
        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);
        school.add(student5);
        school.add(student6);
        checkList.add(student1);
        checkList.add(student3);
        checkList.add(student5);
        Predicate<Student> predicate = x -> x.score >= 70;
        assertTrue(school.collect(school.getStudents(), predicate).containsAll(checkList));
    }

    @Test
    public void getListClassB() {
        School school = new School();
        Student student1 = new Student(70);
        Student student2 = new Student(45);
        Student student3 = new Student(85);
        Student student4 = new Student(60);
        Student student5 = new Student(95);
        Student student6 = new Student(65);
        List<Student> checkList = new ArrayList<>();
        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);
        school.add(student5);
        school.add(student6);
        checkList.add(student4);
        checkList.add(student6);
        Predicate<Student> predicate = x -> (x.score < 70) && (x.score >= 50);
        assertTrue(school.collect(school.getStudents(), predicate).containsAll(checkList));
    }

    @Test
    public void getListClassC() {
        School school = new School();
        Student student1 = new Student(70);
        Student student2 = new Student(45);
        Student student3 = new Student(85);
        Student student4 = new Student(60);
        Student student5 = new Student(95);
        Student student6 = new Student(65);
        List<Student> checkList = new ArrayList<>();
        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);
        school.add(student5);
        school.add(student6);
        checkList.add(student2);
        Predicate<Student> predicate = x -> x.score < 50;
        assertTrue(school.collect(school.getStudents(), predicate).containsAll(checkList));
    }
}
