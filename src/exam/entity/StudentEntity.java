package exam.entity;

import exam.controller.MyCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//3tier 아키텍처에서 DB(객체 배열)와의 연동을 담당 -> 비즈니스 로직(서비스)을 처리
public class StudentEntity {


    //처음 프로그램 시작할 때 5명의 학생을 기본값으로 넣어둔다.
    public List<Student> initStudents() {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student(1, "핀", 100, 80, 90);
        Student student2 = new Student(2, "제이크", 80, 80, 80);
        Student student3 = new Student(3, "비모", 90, 50, 50);
        Student student4 = new Student(4, "버블검", 100, 100, 100);
        Student student5 = new Student(5, "마셀린", 70, 70, 70);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        System.out.println(studentList.get(0));

        return studentList;
    }

    //시스템 시작 메뉴
    public void menu() {
        System.out.println("메뉴를 고르세요. 1 : 학생 추가 / 2 : 이름 검색 / 3 : 전체 석차 / 4 : 학생 정보 수정 / 5 : 학생 삭제");
    } // menu end

    //학생 추가
    public void addStudent(List<Student> studentList) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("추가할 학생의 이름을 입력하세요.");
        String word1 = sc1.nextLine(); // 이름 입력 받음

        if (word1.matches("^[가-힣]*$") && !word1.isEmpty()) {//한글만 허용하고, 공백은 허용하지 않는 정규표현식
            int newNum = studentList.size() + 1;
            Student student = new Student(newNum, word1, 0, 0, 0); // 최초 성적은 0으로 설정
            studentList.add(student); // 학생 배열에 추가
            System.out.println(word1 + " 학생을 시스템에 추가했습니다.");
            System.out.println(studentList.get(newNum-1).toString()); // 추가한 학생 정보 출력
        } else {
            System.out.println("한글만 입력할 수 있습니다.");
        }

    } // addStudent end

    //전체 석차
    public void sortStudents(List<Student> studentList) {
        Collections.sort(studentList, new MyCompare());
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i+1 + " 등 : " + studentList.get(i).getStuName());
        }
    } // sortStudents end

    //학생 수정
    public void editStudents(List<Student> studentList){
        System.out.println("학생 정보 수정 입니다. 수정할 학생의 학번 또는 이름을 입력하세요.");
        Scanner sc1 = new Scanner(System.in);
        String word = sc1.nextLine();
        if(word.)
    }

}
