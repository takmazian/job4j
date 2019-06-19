package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class SchoolTest {

    private List<Student> students = new ArrayList<>();

    @Test
    public void getListClassA() {
        School school = new School();
        Student student1 = new Student(70, null);
        Student student2 = new Student(45, null);
        Student student3 = new Student(85, null);
        Student student4 = new Student(60, null);
        Student student5 = new Student(95, null);
        Student student6 = new Student(65, null);
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
        Student student1 = new Student(70, null);
        Student student2 = new Student(45, null);
        Student student3 = new Student(85, null);
        Student student4 = new Student(60, null);
        Student student5 = new Student(95, null);
        Student student6 = new Student(65, null);
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
        Student student1 = new Student(70, null);
        Student student2 = new Student(45, null);
        Student student3 = new Student(85, null);
        Student student4 = new Student(60, null);
        Student student5 = new Student(95, null);
        Student student6 = new Student(65, null);
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

    @Test
    public void listToMap() {
        Student student1 = new Student(70, "Petrov");
        Student student2 = new Student(45, "Vasilyev");
        Student student3 = new Student(85, "Ivanov");
        School school = new School();
        assertThat(school.transform(List.of(student1, student2, student3)), equalTo(Map.of(student1.lastName, student1.score, student2.lastName, student2.score, student3.lastName, student3.score)));
    }

    @Test
    public void levelOfTest(){
        Student student1 = new Student(70, "Petrov");
        Student student2 = new Student(70, "Vasilyev");
        School school = new School();
        List<Student> list = new ArrayList<>();
        list.add(student2);
        list.add(null);
        list.add(student1);
        List<Student> students = school.levelOf(list,60);
        assertThat(students,equalTo(List.of(student1,student2)));
    }
}
