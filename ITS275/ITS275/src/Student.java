
public class Student {
    private String Name;
    private double DiscussionGrade;
    private double HomeworkGrade ;
    private double MidtermGrade;
    private double FinalGrade;
    private double GradePointAverage;
    private Character LetterGrade;

    public Student(String name, double discussionGrade, double homeworkGrade, double midtermGrade, double finalGrade) {
        Name = name;
        DiscussionGrade = discussionGrade;
        HomeworkGrade = homeworkGrade;
        MidtermGrade = midtermGrade;
        FinalGrade = finalGrade;
        GradePointAverage = setGradePointAverage();
        LetterGrade = setLetterGrade(GradePointAverage);
    }

    public double setGradePointAverage(){
        return (getDiscussionGrade() + getHomeworkGrade() + getMidtermGrade() + getFinalGrade()) / 4;
    }

    public Character setLetterGrade(double GradePointAverage){
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
        if (GradePointAverage >= 60 && GradePointAverage < 70)
            LetterGrade = 'D';
        else
        if (GradePointAverage < 60)
            LetterGrade = 'F';
        return LetterGrade;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getDiscussionGrade() {
        return DiscussionGrade;
    }

    public void setDiscussionGrade(double discussionGrade) {
        DiscussionGrade = discussionGrade;
    }

    public double getHomeworkGrade() {
        return HomeworkGrade;
    }

    public void setHomeworkGrade(double homeworkGrade) {
        HomeworkGrade = homeworkGrade;
    }

    public double getMidtermGrade() {
        return MidtermGrade;
    }

    public void setMidtermGrade(double midtermGrade) {
        MidtermGrade = midtermGrade;
    }

    public double getFinalGrade() {
        return FinalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        FinalGrade = finalGrade;
    }

    public double getGradePointAverage() {
        return GradePointAverage;
    }

    public Character getLetterGrade() {
        return LetterGrade;
    }

        @Override
    public String toString(){
        return ("Name:                   " + getName() + '\n' +
                "Discussion Grade:       " + getDiscussionGrade() + '\n' +
                "Homework Grade:         " + getHomeworkGrade() + '\n' +
                "MidtermGrade:           " + getDiscussionGrade() + '\n' +
                "Final Grade:            " + getFinalGrade() + '\n' +
                "Grade Point Average:    " + getGradePointAverage() + '\n' +
                "Letter Grade:           " + getLetterGrade()) + '\n';
    }
}
