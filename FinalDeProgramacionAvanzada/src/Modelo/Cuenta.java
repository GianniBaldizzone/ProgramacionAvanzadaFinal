package Modelo;

public class Cuenta {

	    private int id;
	    private int numeroCuenta;
	    private double saldo;
	    private String pin;
	    private TipoCuenta tipoCuenta;
	    private int usuarioId;

	    public Cuenta(int id, int numeroCuenta, double saldo, String pin, TipoCuenta tipoCuenta, int usuarioId) {
	        this.id = id;
	        this.numeroCuenta = numeroCuenta;
	        this.saldo = saldo;
	        this.pin = pin;
	        this.tipoCuenta = tipoCuenta;
	        this.usuarioId = usuarioId;
	    }

	    // Getters y Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getNumeroCuenta() {
	        return numeroCuenta;
	    }

	    public void setNumeroCuenta(int numeroCuenta) {
	        this.numeroCuenta = numeroCuenta;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

	    public String getPin() {
	        return pin;
	    }

	    public void setPin(String pin) {
	        this.pin = pin;
	    }

	    public TipoCuenta getTipoCuenta() {
	        return tipoCuenta;
	    }

	    public void setTipoCuenta(TipoCuenta tipoCuenta) {
	        this.tipoCuenta = tipoCuenta;
	    }

	    public int getUsuarioId() {
	        return usuarioId;
	    }

	    public void setUsuarioId(int usuarioId) {
	        this.usuarioId = usuarioId;
	    }
	}

