package sesion3A;

public class Movimiento {
    public enum Signo { D, H } // D = Retiro, H = Ingreso
    
    public Double importe;
    public Signo signo;
    public String detalle;

    public Movimiento(Double importe, Signo signo, String detalle) {
        this.importe = importe;
        this.signo = signo;
        this.detalle = detalle;
    }
}