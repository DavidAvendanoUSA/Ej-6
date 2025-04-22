package Banco_Mucha_Plata;

import java.sql.Date;

public class cuentaVivienda extends Cuenta {
    private Date fechaUltimoAbono;
    protected double valorUltimoAbono;

    public cuentaVivienda(Date fechaUltimoAbono, double valorUltimoAbono, int numerProducto, int anioApertura, double saldo, Titular titular) {
        super(numerProducto, anioApertura, saldo, titular);
        this.fechaUltimoAbono = fechaUltimoAbono;
        this.valorUltimoAbono = valorUltimoAbono;
    }

    public Date getFechaUltimoAbono() {
        return fechaUltimoAbono;
    }

    public void setFechaUltimoAbono(Date fechaUltimoAbono) {
        this.fechaUltimoAbono = fechaUltimoAbono;
    }

    public double getValorUltimoAbono() {
        return valorUltimoAbono;
    }

    public void setValorUltimoAbono(double valorUltimoAbono) {
        this.valorUltimoAbono = valorUltimoAbono;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            this.valorUltimoAbono = monto;
            this.fechaUltimoAbono = new Date(System.currentTimeMillis());
            System.out.println("Abono realizado: " + monto);
        } else {
            System.out.println("Monto inválido para abono.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            this.valorUltimoAbono = -monto;
            this.fechaUltimoAbono = new Date(System.currentTimeMillis());
            System.out.println("Retiro exitoso: " + monto);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    @Override
    public String mostrarDatos() {
        return "Cuenta Vivienda - " + super.numerProducto + " - " + titular.getNombre()
            + " - Último Abono: " + fechaUltimoAbono + " - Valor: " + valorUltimoAbono + " - Saldo: " + saldo;
    }
}
