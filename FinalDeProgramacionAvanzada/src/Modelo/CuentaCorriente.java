package Modelo;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int id, int numeroCuenta, double saldo, String pin, int usuarioId) {
        super(id, numeroCuenta, saldo, pin, TipoCuenta.CUENTA_CORRIENTE, usuarioId);
    }
}
