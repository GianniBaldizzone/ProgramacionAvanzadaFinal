package Modelo;

public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(int id, int numeroCuenta, double saldo, String pin, int usuarioId) {
        super(id, numeroCuenta, saldo, pin, TipoCuenta.CAJA_DE_AHORRO, usuarioId);
    }
}
