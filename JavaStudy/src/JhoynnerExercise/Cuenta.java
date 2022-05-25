package JhoynnerExercise;

public class Cuenta {
    protected int numeroDeCuenta;
    protected String nombrePropietario;
    protected int id;
    protected int saldo;

    public Cuenta(String nombrePropietario, int numeroDeCuenta, int id, int saldo){
        this.numeroDeCuenta = numeroDeCuenta;
        this.nombrePropietario = nombrePropietario;
        this.id = id;
        this.saldo = saldo;
    }

    public void consignar(int consignacion){}

    public void retirar(int retiro){}

    public void crear(){}
}
