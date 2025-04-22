package Banco_Mucha_Plata;

import java.sql.Date;

public class TarjetaCredito extends Cuenta {
    private double cupoMaximo;
    private double deudaActual;
    private Date fechaUltimaCompra;

    public TarjetaCredito(double cupoMaximo, double deudaActual, Date fechaUltimaCompra, int numerProducto, int anioApertura, double saldo, Titular titular) {
        super(numerProducto, anioApertura, saldo, titular);
        this.cupoMaximo = cupoMaximo;
        this.deudaActual = deudaActual;
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public double getDeudaActual() {
        return deudaActual;
    }

    public void setDeudaActual(double deudaActual) {
        this.deudaActual = deudaActual;
    }

    public Date getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(Date fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            deudaActual -= monto;
            if (deudaActual < 0) deudaActual = 0;
            System.out.println("Pago realizado a la tarjeta: " + monto);
        } else {
            System.out.println("Monto inválido para pago.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && (deudaActual + monto) <= cupoMaximo) {
            deudaActual += monto;
            this.fechaUltimaCompra = new Date(System.currentTimeMillis());
            System.out.println("Compra realizada por: " + monto);
        } else {
            System.out.println("Compra rechazada. Excede el cupo o monto inválido.");
        }
    }

    @Override
    public String mostrarDatos() {
        return "Tarjeta de Crédito - " + super.numerProducto + " - " + titular.getNombre()
            + " - Cupo Máximo: " + cupoMaximo + " - Deuda Actual: " + deudaActual 
            + " - Última Compra: " + fechaUltimaCompra;
    }
}
