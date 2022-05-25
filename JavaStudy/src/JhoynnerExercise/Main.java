package JhoynnerExercise;

public class Main {
    public static void main(String[] args){
        Cuenta ahorros = new CuentaDeAhorros("Jhoynner",1234,5678, 0);
        Cuenta inversion = new CuentaDeInversion("Jhoynner2",2468,1357, 0);

        ahorros.crear();
        inversion.crear();
        ahorros.consignar(2000);
        inversion.retirar(26000);
        System.out.println(ahorros.saldo);
        System.out.println(inversion.saldo);
    }
}