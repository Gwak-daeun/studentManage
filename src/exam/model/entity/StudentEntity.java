package exam.model.entity;

import exam.controller.MyCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//3tier 아키텍처에서 DB(객체 배열)와의 연동을 담당 -> 비즈니스 로직(서비스)을 처리
public class StudentEntity {

    //Scanner 멤버변수로 빼서 메서드 안에서는 nextLine()으로 꺼내쓰기. 메서드 안에서 일일히 생성자로 만들어 쓰면 자원낭비
    Scanner sc = new Scanner(System.in);

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
        System.out.println("메뉴를 고르세요. 1 : 학생 추가 / 2 : 이름 검색 / 3 : 전체 석차 / 4 : 학생 정보 수정 / 5 : 학생 삭제 / 6 : 종료하기");
    } // menu end

    //학생 추가
    public void addStudent(List<Student> studentList) {

        while (true) {
            System.out.println("추가할 학생의 이름을 입력하세요.");

            String word1 = sc.nextLine(); // 이름 입력 받음

            if (word1.matches("^[가-힣]*$") && !word1.isEmpty()) {//한글만 허용하고, 공백은 허용하지 않는 정규표현식
                int newNum = studentList.size() + 1;
                Student student = new Student(newNum, word1, 0, 0, 0); // 최초 성적은 0으로 설정
                studentList.add(student); // 학생 배열에 추가
                System.out.println(word1 + " 학생을 시스템에 추가했습니다.");
                System.out.println(studentList.get(newNum - 1).toString()); // 추가한 학생 정보 출력
                return;
            } else {
                System.out.println("한글만 입력할 수 있습니다.");
            }
        }

    } // addStudent end

    //이름 검색
    public void searchStudent(List<Student> studentList) {

        while (true) {

            System.out.println("전체 학생 조회: 1 / 개별 학생 검색 : 2");

            String word1 = sc.nextLine();
            // sc.nextLine()이 while문 안에 있어야 case 조건문 이외의 선택을 했을 때 무한반복 하지 않고 다시 while을 돌 때 sc.nextLine()에 걸려서 다시 입력받는다.

            switch (word1) {
                case "1":
                    System.out.println("==========전체 학생 조회==========");

                    for (int i = 0; i < studentList.size(); i++) {
                        System.out.println(studentList.get(i));
                    }
                    return; // 메소드 빠져나가기
                case "2":
                    System.out.println("==========개별 학생 검색==========");

                    System.out.println("검색할 학생의 이름을 입력하세요.");
                    String word2 = sc.nextLine();
                    System.out.println(word2);

                    for (int i = 0; i < studentList.size(); i++) {
                        if (word2.equals(studentList.get(i).getStuName()) && word2.matches("^[가-힣]*$")) { //한글만 허용, 공백 허용하지 않는 정규표현식 && 학생 이름 찾기
                            System.out.println("검색한 학생: " + word2);
                            System.out.println(studentList.get(i));
                            return;
                        }
                    } // for end

                    if (!word2.matches("^[가-힣]*$") || word2.length() == 0) {
                        System.out.println("검색 실패. 잘못입력하셨습니다.");
                    }

                    break;
                default:
                    System.out.println("메뉴에 있는 버튼을 클릭해주세요.");
                    break;
            }

        }


    } //searchStudent end

    //전체 석차
    public void sortStudents(List<Student> studentList) {
        Collections.sort(studentList, new MyCompare());
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i + 1 + " 등 : " + studentList.get(i).getStuName());
        }
    } // sortStudents end

    //학생 수정
    public void editStudents(List<Student> studentList) {
        System.out.println("학생 정보 수정 입니다. 수정할 학생의 학번 또는 이름을 입력하세요.");

        String word = sc.nextLine();
        boolean isNumber = word.matches("\\d+"); // 사용자가 숫자를 입력했는지 문자열을 입력했는지 체크하기 위한 변수
        int count = 0;
        if (isNumber) { // 숫자 입력
//            System.out.println("찾을 학번: " + word);
            for (int i = 0; i < studentList.size(); i++) { // 입력한 학번으로 학생 찾기

                if (Integer.parseInt(word) == studentList.get(i).getStuNo()) { //문자열로 입력한 숫자를 int로 변환
                    System.out.println("==========학번 " + word + " 번 학생==========");
                    System.out.println(studentList.get(i));
                    System.out.println("===========================================");
                    System.out.println("수정할 항목을 선택하세요.");
                    System.out.println("1: 이름 / 2: 국어 점수 / 3: 영어 점수 / 4: 수학 점수");

                    String word2 = sc.nextLine();

                    stuSwitch(studentList, word2, i); // 수정 항목 선택 스위치문

                    count = 1;

                }
            }

            if (count == 0) {
                System.out.println(word + " 번 학생을 찾을 수 없습니다.");
            }

        } else { // 문자 입력

            for (int i = 0; i < studentList.size(); i++) { // 입력한 이름으로 학생 찾기

                if (word.equals(studentList.get(i).getStuName())) {
                    System.out.println("==========찾을 학생 : " + word + "==========");
                    System.out.println(studentList.get(i));
                    System.out.println("===========================================");
                    System.out.println("수정할 항목을 선택하세요.");
                    System.out.println("1: 이름 / 2: 국어 점수 / 3: 영어 점수 / 4: 수학 점수");

                    String word2 = sc.nextLine();

                    stuSwitch(studentList, word2, i); // 수정 항목 선택 스위치문
                    count = 1;
                }
            }

            if (count == 0) {
                System.out.println("이름이 \"" + word + "\" 인 학생을 찾을 수 없습니다.");
            }

        }

    } //editStudents end

    public void deleteStudent(List<Student> studentList) {
        System.out.println("삭제할 학생의 이름을 입력하세요.");

        String word = sc.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            if (word.equals(studentList.get(i).getStuName())) {
                System.out.println("학생 " + studentList.get(i).getStuName() + " 을 삭제하시려면 \"삭제합니다\"를 입력하세요.");
                String word2 = sc.nextLine();
                String delStu = studentList.get(i).getStuName();
                if (word2.equals("삭제합니다")) {
                    System.out.println("삭제 시작");
                    studentList.remove(i);
                    System.out.println("\"" + delStu + "\" 학생 삭제 완료");
                    return; // 메소드 빠져나가기
                } else {
                    System.out.println("삭제 취소. 잘못입력하셨습니다.");
                }
            }
        }
    } // deleteStudent end


    // 수정 항목 선택 스위치문
    public void stuSwitch(List<Student> studentList, String word2, int i) {
        switch (word2) {
            case "1":
                System.out.println("이름 수정");
                System.out.println("이름: " + studentList.get(i).getStuName());
                System.out.println("수정할 이름을 입력하세요.");
                String word3 = sc.nextLine();
                studentList.get(i).setStuName(word3);
                System.out.println("수정된 이름: " + word3);
                break;

            case "2":
                System.out.println("국어 점수 수정");
                System.out.println(studentList.get(i).getStuName() + " 의 국어 점수: " + studentList.get(i).getKorScore());
                System.out.println("수정할 점수를 입력하세요.");
                String word4 = sc.nextLine();
                studentList.get(i).setKorScore(Integer.parseInt(word4));
                System.out.println("수정된 국어 점수: " + word4);
                break;

            case "3":
                System.out.println("영어 점수 수정");
                System.out.println(studentList.get(i).getStuName() + " 의 영어 점수: " + studentList.get(i).getMathScore());
                System.out.println("수정할 점수를 입력하세요.");
                String word5 = sc.nextLine();
                studentList.get(i).setMathScore(Integer.parseInt(word5));
                System.out.println("수정된 영어 점수: " + word5);
                break;

            case "4":
                System.out.println("수학 점수 수정");
                System.out.println(studentList.get(i).getStuName() + " 의 수학 점수: " + studentList.get(i).getMathScore());
                System.out.println("수정할 점수를 입력하세요.");
                String word6 = sc.nextLine();
                studentList.get(i).setMathScore(Integer.parseInt(word6));
                System.out.println("수정된 수학 점수: " + word6);
                break;

            default:

                break;
        }
    } //stuSwitch end

}
