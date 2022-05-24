import java.util.Scanner;

public class ChallengeN1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String question = "Which rock band is older? Answer with a, b or c";
        String firstOption = "a) The beatles";
        String secondOption = "b) Ramones";
        String thirdOption = "c) Rolling Stones";
        String correctAnswer = "a";

        System.out.println(question);
        System.out.println(firstOption);
        System.out.println(secondOption);
        System.out.println(thirdOption);
        String answer = input.next();


        while(!answer.equals(correctAnswer)) {
            System.out.println("Try again");
            answer = input.next();
        }
        System.out.println("Congrats! Your answer is correct");
    }
}
