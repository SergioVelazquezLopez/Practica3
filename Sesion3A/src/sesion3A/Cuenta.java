package sesion3A;

import java.util.ArrayList;
import java.util.List;

public class Cuenta { 
    String mNumero; 
    String nTitular; 
    List<Movimiento> mMovimientos = new ArrayList<>();
    List<String> errores = new ArrayList<>(); 
    Double saldo = 0.0;

    // Modificamos el constructor para aceptar un saldo inicial
    public Cuenta(String numero, String titular, double saldoInicial) {
        this.mNumero = numero;
        this.nTitular = titular;
        this.saldo = saldoInicial;
    }

    public void ingresar(double x) {
        this.saldo += x;
        this.mMovimientos.add(new Movimiento(x, Movimiento.Signo.H, "Ingreso en cuenta"));
    }

    public void retirar(double x) {
        // Comprobamos el limite de descubierto (-500€)
        if ((this.saldo - x) < -500.0) {
            // Si supera el limite, registramos el error y no se modifica el saldo
            String errorMsg = "Fondos insuficientes (saldo " + this.saldo + "€) en la cuenta " + this.mNumero + " para el reintegro de " + x + "€";
            errores.add(errorMsg);
        } else {
            // Si hay fondos, realizamos el retiro
            this.saldo -= x;
            this.mMovimientos.add(new Movimiento(x, Movimiento.Signo.D, "Retiro de cuenta"));
        }
    }
    
    public Double getSaldo() {
        return saldo;
    }

    public List<Movimiento> getmMovimientos() {
        return mMovimientos;
    }
    
    public List<String> getErrores() {
        return errores;
    }
}