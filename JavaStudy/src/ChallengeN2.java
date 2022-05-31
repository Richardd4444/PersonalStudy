public class ChallengeN2 {
    public static double employeeSalary(double hoursPerWeek, double amountPerHour, double vacationDays){
        if(hoursPerWeek < 0){
            return -1;
        }
        if(amountPerHour < 0){
            return -1;
        }
        return ((hoursPerWeek*amountPerHour) - (vacationDays*8*amountPerHour))*52 ;
    }

    public static void main(String[] args){
        double salary = employeeSalary(40,15.5,0);
        System.out.println("The salary of a year is " + salary);
    }
}
