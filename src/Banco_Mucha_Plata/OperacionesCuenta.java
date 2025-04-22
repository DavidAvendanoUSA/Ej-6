package Banco_Mucha_Plata;

public interface OperacionesCuenta {
    void depositar(double monto);
    void retirar(double monto);
    String mostrarDatos();
}
