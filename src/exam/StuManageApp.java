package exam;


import exam.entity.Student;
import exam.entity.StudentEntity;

import java.util.List;
import java.util.Scanner;

// 학생 정보 및 성적 관리를 위한 프로그램의 main() 메소드가 있는 시작 클래스
//3tier 아키텍처에서 client 역할을 담당
public class StuManageApp {
    public static void main(String[] args) {

        StudentEntity studentEntity = new StudentEntity();

       List<Student> studentList = studentEntity.initStudents(); // 처음 학생을 넣은 studentList를 받음

        while (true) {
            studentEntity.menu();
            Scanner sc1 = new Scanner(System.in);
            String num1 = sc1.nextLine();
            switch (num1) {
                case "1": //학생 추가
                    studentEntity.addStudent(studentList);
                    break;
                case "2": // 이름 검색
                    studentEntity.searchStudent(studentList);
                    break;
                case "3": //석차
                    studentEntity.sortStudents(studentList);
                    break;
                case "4": //수정
                    studentEntity.editStudents(studentList);
                    break;

                case "5": //삭제
                    studentEntity.deleteStudent(studentList);
                    break;

                case "6": // 나가기
                    System.out.println("학생 관리 시스템을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못 입력 하셨습니다. 메뉴에 있는 숫자를 입력하세요.");
                    break;
            }

        }

    }
}

