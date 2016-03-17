
public class GraduateStudent extends Student {
    private Character LetterGrade;
    public GraduateStudent(String name, double discussionGrade, double homeworkGrade, double midtermGrade, double finalGrade) {
        super(name, discussionGrade, homeworkGrade, midtermGrade, finalGrade);
    }

    @Override
    public Character setLetterGrade(double GradePointAverage) {
        Character LetterGrade = ' ';
        if (GradePointAverage >= 90)
            LetterGrade = 'A';
        else
        if (GradePointAverage >= 80 && GradePointAverage < 90)
            LetterGrade = 'B';
        else
        if (GradePointAverage >= 70 && GradePointAverage < 80)
            LetterGrade = 'C';
        else
        if (GradePointAverage < 70)
            LetterGrade = 'F';
        return LetterGrade;
    }

    @Override
    public double setGradePointAverage() {
        return getDiscussionGrade() * 0.1 + getHomeworkGrade() * 0.3 + getMidtermGrade() * 0.3 + getFinalGrade() * 0.3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
