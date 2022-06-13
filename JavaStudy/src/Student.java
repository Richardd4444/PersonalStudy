public class Student {
    String studentFirstName;
    String studentLastName;
    int expectedYearToGraduate;
    double gpa;

    public Student(String studentFirstName, String studentLastName, int expectedYearToGraduate, double gpa){
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.expectedYearToGraduate = expectedYearToGraduate;
        this.gpa = gpa;
    }

    public void increaseGraduateYear(){
        this.expectedYearToGraduate = this.expectedYearToGraduate + 1;
    }
}
