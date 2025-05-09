package Banco_Mucha_Plata;

public abstract class Cuenta implements OperacionesCuenta {
    protected int numerProducto; 
    protected int anioApertura; 
    protected double saldo; 
    protected Titular titular; 

    public Cuenta(int numerProducto, int anioApertura, double saldo, Titular titular) {
        this.titular = titular; 
        this.numerProducto = numerProducto; 
        this.anioApertura = anioApertura; 
        this.saldo = saldo;
    }

    public int getAnioApertura() {
        return anioApertura;
    }

    public int getNumerProducto() {
        return numerProducto;
    }

    public double getSaldo() {
        return saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setAnioApertura(int anioApertura) {
        this.anioApertura = anioApertura;
    }

    public void setNumerProducto(int numerProducto) {
        this.numerProducto = numerProducto;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    @Override
    public abstract void depositar(double monto); 
    @Override
    public abstract void retirar(double monto); 
    @Override
    public abstract String mostrarDatos();  
}


