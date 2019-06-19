package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    private List<Student> studentList = new ArrayList<>();

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    Map<String, Integer> transform(List<Student> students) {
        return students.stream().collect(Collectors.toMap(e -> e.lastName, e -> e.score));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        Comparator<Student> comparator = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 == null) {
                    return -1;
                } else if (o1 == null && o2 != null) {
                    return 1;
                } else {
                    int compareLastNames = o1.lastName.compareTo(o2.lastName);
                    return compareLastNames == 0 ? Integer.compare(o1.score, o2.score) : compareLastNames;
                }
            }
        };
        return students.stream().sorted(comparator).flatMap(Stream::ofNullable).takeWhile(v -> v.score > bound).collect(Collectors.toList());
    }

    void add(Student student) {
        studentList.add(student);
    }

    List<Student> getStudents() {
        return studentList;
    }
}
