package Banco_Mucha_Plata;

import java.sql.Date;

public class CuentaCorriente extends Cuenta {
    private Date fechaUltimoMovimiento;
    protected double valorUltimoMovimiento;
    private String tipoOperacion;

    public CuentaCorriente(Date fechaUltimoMovimiento, double valorUltimoMovimiento, String tipoOperacion, int numerProducto, int anioApertura, double saldo, Titular titular) {
        super(numerProducto, anioApertura, saldo, titular);
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
        this.valorUltimoMovimiento = valorUltimoMovimiento;
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public void setFechaUltimoMovimiento(Date fechaUltimoMovimiento) {
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
    }

    public double getValorUltimoMovimiento() {
        return valorUltimoMovimiento;
    }

    public void setValorUltimoMovimiento(double valorUltimoMovimiento) {
        this.valorUltimoMovimiento = valorUltimoMovimiento;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            this.valorUltimoMovimiento = monto;
            this.fechaUltimoMovimiento = new Date(System.currentTimeMillis());
            this.tipoOperacion = "Depósito";
            System.out.println("Depósito realizado: " + monto);
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            this.valorUltimoMovimiento = monto;
            this.fechaUltimoMovimiento = new Date(System.currentTimeMillis());
            this.tipoOperacion = "Retiro";
            System.out.println("Retiro exitoso: " + monto);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    @Override
    public String mostrarDatos() {
        return "Cuenta Corriente - " + super.numerProducto + " - " + titular.getNombre()
            + " - Último Movimiento: " + fechaUltimoMovimiento + " - Valor: " + valorUltimoMovimiento
            + " - Tipo de operación: " + tipoOperacion + " - Saldo: " + saldo;
    }
}


