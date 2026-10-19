package sesion3A;

import java.util.ArrayList;
import java.util.List;

public class Cuenta { 
    String mNumero; 
    String nTitular; 
    List<Movimiento> mMovimientos = new ArrayList<>();
    Double saldo = 0.0;

    public Cuenta(String numero, String titular) {
        this.mNumero = numero;
        this.nTitular = titular;
    }

    public void ingresar(double x) {    
    }

    public void retirar(double x) {
    }
    
    public Double getSaldo() {
        return saldo;
    }
}
