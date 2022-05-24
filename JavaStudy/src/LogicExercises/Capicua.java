package LogicExercises;

public class Capicua {
    public boolean isPalindrome(int x) {
        if(x < 0 || x % 10 == 0 && x !=0){
            return false;
        }

        int inv = 0;
        while(x > inv){
            inv = inv*10 + x%10;
            x /= 10;
        }
        return x ==  inv || x == inv/10;
    }
}
