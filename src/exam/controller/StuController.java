package exam.controller;


import exam.model.entity.Student;
import exam.service.StudentImpl;

import java.util.List;
import java.util.Scanner;

//3tier 아키텍처에서 client의 request를 받는 역할을 담당
//client의 해당 request에 대한 서비스와 매핑을 해주는 역할을 담당
//성적 관리 프로그램의 전체적인 기능적 요소 관리
public class StuController {

    StudentImpl student = new StudentImpl();

   public void startManage() {

        List<Student> studentList = student.initStudents();

        while (true) {
            student.menu();
            Scanner sc = new Scanner(System.in);
            String num = sc.nextLine();
            switch (num) {
                case "1": //학생 추가
                    student.addStudent(studentList);
                    break;
                case "2": // 이름 검색
                    student.searchStudent(studentList);
                    break;
                case "3": //석차
                    student.sortStudents(studentList);
                    break;
                case "4": //수정
                    student.editStudents(studentList);
                    break;

                case "5": //삭제
                    student.deleteStudent(studentList);
                    break;

                case "6": // 나가기
                    System.out.println("학생 관리 시스템을 종료합니다.");
                    System.exit(0); // 정상적인 종료

                default:
                    System.out.println("잘못 입력 하셨습니다. 메뉴에 있는 숫자를 입력하세요.");
                    break;
            }

        }
    }

}
