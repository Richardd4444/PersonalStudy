package JhoynnerExercise;

public class CuentaDeAhorros extends Cuenta {
    private int montoMinimo = 500;
    private int montoInicial = 1000;

    public CuentaDeAhorros(String nombrePropietario, int id, int numeroDeCuenta, int saldo){
        super(nombrePropietario,id,numeroDeCuenta,saldo);
    }

    @Override
    public void consignar(int consignacion){
        saldo = saldo+consignacion;
    }

    @Override
    public void retirar(int retiro){
        int aux = saldo-retiro;
        if(aux < montoMinimo){
            System.out.println("No puede realizar el retiro de la cuenta de ahorros");
        } else { saldo = saldo-retiro; }
    }

    @Override
    public void crear(){
        saldo = montoInicial;
    }
}
