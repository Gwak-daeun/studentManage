package exam;


import exam.controller.StuController;


// 학생 정보 및 성적 관리를 위한 프로그램의 main() 메소드가 있는 시작 클래스
//3tier 아키텍처에서 client 역할을 담당
public class StuManageApp {
    public static void main(String[] args) {

        StuController stuController = new StuController();

        stuController.startManage();

    }
}

