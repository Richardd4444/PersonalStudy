package LogicExercises;
import java.util.Map;
import java.util.HashMap;

public class Exercise3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int output = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0, j = 0; i< s.length(); i++){
                char x = s.charAt(i);
                if(map.containsKey(s.charAt(i))){
                    j = Math.max(map.get(s.charAt(i)), i);
                }
                output = Math.max(output, i - j + 1);
                map.put(s.charAt(i), i+1);
            }
            return output;
        }
    }
}
