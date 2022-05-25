package LogicExercises;

import java.util.HashMap;

public class RepeatedChar {
    public static void main(String[] args){
        HashMap<Character,Integer> map = new HashMap<>();
        String s = "abcabcbb";
        int count = 0;
        for(int i = 0; i<s.length();i++){
            for(int j=0; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
            }
            map.put(s.charAt(i),count);
            count = 0;
        }
        System.out.println(map);
    }
}