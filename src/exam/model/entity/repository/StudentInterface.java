package exam.model.entity.repository;

import exam.model.entity.Student;

import java.util.List;

public interface StudentInterface {
    List<Student> initStudents();

    void menu();

    void addStudent(List<Student> studentList);

    void searchStudent(List<Student> studentList);

    void sortStudents(List<Student> studentList);

    void editStudents(List<Student> studentList);

    void deleteStudent(List<Student> studentList);

}
