package Banco_Mucha_Plata;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Titular titular = new Titular("Juan Perez", "juan.perez@mail.com", 123);

        CuentaAhorros cuentaAhorros = new CuentaAhorros(new Date(System.currentTimeMillis()), 500, 1, 2022, 2000, titular);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(new Date(System.currentTimeMillis()), 300, "Depósito", 2, 2023, 1500, titular);
        cuentaVivienda cuentaVivienda = new cuentaVivienda(new Date(System.currentTimeMillis()), 10000, 3, 2020, 8000, titular);
        TarjetaCredito tarjetaCredito = new TarjetaCredito(5000, 1000, new Date(System.currentTimeMillis()), 4, 2021, 2000, titular);

        Financiera financiera = new Financiera();
        financiera.crearCuenta(cuentaAhorros);
        financiera.crearCuenta(cuentaCorriente);
        financiera.crearCuenta(cuentaVivienda);
        financiera.crearCuenta(tarjetaCredito);

        financiera.realizarDeposito(1, 100);
        financiera.realizarRetiro(2, 200);

        System.out.println("Todas las cuentas:");
        financiera.mostrarCuentas();

        System.out.println("\nCuentas de Ahorro:");
        financiera.mostrarCuentasAhorro();

        System.out.println("\nCuentas Corrientes:");
        financiera.mostrarCuentasCorriente();

        System.out.println("\nCuentas Vivienda:");
        financiera.mostrarCuentasVivienda();

        System.out.println("\nTarjetas de Crédito:");
        financiera.mostrarTarjetasCredito();
    }
}
