package exam.controller;

import exam.entity.Student;

import java.util.Comparator;

public class MyCompare implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {

        if (s1.getAverage() < s2.getAverage()) {
//            System.out.println("평균1" + s1.getAverage());
//            System.out.println("평균2" + s2.getAverage());
            return 1;
        } else if (s1.getAverage() > s2.getAverage()) {
            return -1;
        }
        return 0;
    }
}
