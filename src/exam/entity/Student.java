package exam.entity;

//학생 한 명에 대한 학생 정보 및 국어, 영어, 수학 점수를 정의한 클래스
public class Student {
   private int stuNo; // 학번
    private String stuName; // 학생 이름
    private int korScore; // 국어 점수
    private int engScore; // 영어 점수
    private int mathScore; // 수학 점수
    private float average; // 평균

    public Student() {

    }

    public Student(int stuNo, String stuName, int korScore, int engScore, int mathScore) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
        this.average = (float) (korScore + engScore + mathScore) / 3;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    private String gender; //성별: male, female

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "학생 " + stuName + " : [" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", korScore=" + korScore +
                ", engScore=" + engScore +
                ", mathScore=" + mathScore +
                ", average=" + average +
                ", gender='" + gender + '\'' +
                ']';
    }
}
