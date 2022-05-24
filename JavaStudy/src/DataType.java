import java.util.Scanner;

public class DataType {
    public static void main(String[] args){
        int studentAge = 22;
        System.out.println("Enter the student GPA");
        Scanner input = new Scanner(System.in);
        double studentGpa = input.nextDouble();
        boolean hasPerfectAttendance = true;
        String studentFirstName = "Richard";
        String studentLastName = "Mendoza";
        char studentFirstInitial = studentFirstName.charAt(0);
        char studentSecondInitial = studentLastName.charAt(0);

        System.out.println(studentAge);
        System.out.println(studentGpa);
        System.out.println(studentFirstInitial);
        System.out.println(studentSecondInitial);
        System.out.println(hasPerfectAttendance);
        System.out.println(studentFirstName);
        System.out.println(studentLastName);
        System.out.println(studentFirstName + " " + studentLastName + " has a GPA of " + studentGpa);
    }
}
