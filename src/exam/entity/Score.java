package exam.entity;

//학생 개인 점수 관련 클래스
public class Score {
    int totalScore; // 국어 + 영어 + 수학
    int average; // (국어 + 영어 + 수학) / 과목 수

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
}
