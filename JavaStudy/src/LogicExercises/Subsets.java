package LogicExercises;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for(int num : nums){
            List<List<Integer>> newSubset = new ArrayList<>();
            for(List<Integer> curr : result){
                newSubset.add(new ArrayList<Integer>(curr){
                    {add(num);}
                });
            }
            for(List<Integer> curr : newSubset){
                result.add(curr);
            }
        }
        System.out.println(result);
    }
}
