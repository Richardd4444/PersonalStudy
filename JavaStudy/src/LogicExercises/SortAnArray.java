package LogicExercises;

public class SortAnArray {
    public static void main(String[] args){
        int[] a = {3,2,4,1};
        int aux;
        for(int i =0; i<a.length-1; i++){
            for(int j = 0; j<a.length-1; j++){
                if(a[j] > a[j+1]){
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
        }
        for(int i =0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}