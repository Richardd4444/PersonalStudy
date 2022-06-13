package LogicExercises;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args){
        String A = "000900";
        int mayor = 0;
        LinkedList<String> l = new LinkedList<>();
        for(int i = 0; i<A.length(); i++){
            int aux = Integer.parseInt(String.valueOf(A.charAt(i)));
            if(aux > mayor){
                mayor = aux;
            }
        }
        for(int j = 0; j<A.length(); j++){
            for(int m = 0; m<A.length();m++){
                if(A.charAt(j)==A.charAt(m) && j!=m && (A.charAt(j)!='0')){
                    l.add(String.valueOf(A.charAt(j))+String.valueOf(mayor)+String.valueOf(A.charAt(m)));
                }
            }
        }
        if(l.isEmpty()){
            System.out.println(mayor);
        }else{ System.out.println(l.getLast());}
    }
}
