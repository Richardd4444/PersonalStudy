package LogicExercises;
import java.util.Arrays;

class Demo {
    public static void main(String[] args){
        int[] A = {1,4,56,1,3,6};
        Arrays.sort(A);
        int min = 0;
        for (int j : A) {
            int aux = min + 1;
            if (j > aux) {
                System.out.println(aux);
                break;
            }
            if (j == aux) {
                min++;
            }
        }
    }
}
