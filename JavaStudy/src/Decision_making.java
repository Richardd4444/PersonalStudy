import java.util.Scanner;

public class Decision_making {
    public static void main(String[] args){
        System.out.println("Pick a number between 1 and 10");
        Scanner read = new Scanner(System.in);
        int number = read.nextInt();

        if(number < 5){
            System.out.println("Enjoy the good luck a friend brings you");
        } else {
            System.out.println("Your shoe selection will make you happy today");
        }
    }
}
