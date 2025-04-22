package Banco_Mucha_Plata;

import java.sql.Date;

public class CuentaAhorros extends Cuenta {
    private Date fechaUltimoRetiro; 
    protected double valorUltimoRetiro; 

    public CuentaAhorros(Date fechaUltimoRetiro, double valorUltimoRetiro, int numerProducto, int anioApertura, double saldo, Titular titular) {
        super(numerProducto, anioApertura, saldo, titular);
        this.valorUltimoRetiro = valorUltimoRetiro; 
        this.fechaUltimoRetiro = fechaUltimoRetiro; 
    }

    public Date getFechaUltimoRetiro() {
        return fechaUltimoRetiro;
    }

    public void setValorUltimoRetiro(double valorUltimoRetiro) {
        this.valorUltimoRetiro = valorUltimoRetiro;
    }

    public void setFechaUltimoRetiro(Date fechaUltimoRetiro) {
        this.fechaUltimoRetiro = fechaUltimoRetiro;
    }

    public double getValorUltimoRetiro() {
        return valorUltimoRetiro;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado: " + monto);
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            this.valorUltimoRetiro = monto;
            this.fechaUltimoRetiro = new Date(System.currentTimeMillis());  
            System.out.println("Retiro exitoso: " + monto);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    @Override
    public String mostrarDatos() {
        return "Cuenta Ahorros - " + super.numerProducto + " - " + titular.getNombre()
            + " - Último Retiro: " + fechaUltimoRetiro + " - Valor: " + valorUltimoRetiro + " - Saldo: " + saldo;
    }
}
