public class ChallengeN3 {
    public static void main(String[] args){
        Student studentA = new Student("Richard", "Mendoza", 2020, 3.8);
        Student studentB = new Student("Leonardo", "Mendoza", 2019, 5);

        studentB.increaseGraduateYear();
        System.out.println(studentA.expectedYearToGraduate);
        System.out.println(studentB.expectedYearToGraduate);

    }
}
