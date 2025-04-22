package Banco_Mucha_Plata;

import java.util.ArrayList;

public class Financiera {
    private ArrayList<Cuenta> cuentas;

    public Financiera() {
        cuentas = new ArrayList<>();
    }

    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void realizarDeposito(int numeroProducto, double monto) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumerProducto() == numeroProducto) {
                cuenta.depositar(monto);
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void realizarRetiro(int numeroProducto, double monto) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumerProducto() == numeroProducto) {
                cuenta.retirar(monto);
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void mostrarCuentas() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.mostrarDatos());
        }
    }

    public void mostrarCuentasAhorro() {
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaAhorros) {
                System.out.println(cuenta.mostrarDatos());
            }
        }
    }

    public void mostrarCuentasCorriente() {
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaCorriente) {
                System.out.println(cuenta.mostrarDatos());
            }
        }
    }

    public void mostrarCuentasVivienda() {
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof cuentaVivienda) {
                System.out.println(cuenta.mostrarDatos());
            }
        }
    }

    public void mostrarTarjetasCredito() {
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof TarjetaCredito) {
                System.out.println(cuenta.mostrarDatos());
            }
        }
    }
}
