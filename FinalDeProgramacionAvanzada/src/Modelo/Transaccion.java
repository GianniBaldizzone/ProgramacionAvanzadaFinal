package Modelo;

import java.sql.Date;

public class Transaccion {
	private int id;
    private Date fechaTransaccion;
    private int cuentaId;
    private double monto;
    private TipoTransaccion tipo;

    // Constructor vacío
    public Transaccion() {
    }

    // Constructor completo
    public Transaccion(int id, Date fechaTransaccion, int cuentaId, double monto, TipoTransaccion tipo) {
        this.id = id;
        this.fechaTransaccion = fechaTransaccion;
        this.cuentaId = cuentaId;
        this.monto = monto;
        this.tipo = tipo;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaTransaccion(Date date) {
        this.fechaTransaccion = new java.sql.Date(date.getTime());
    }


    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

	public TipoTransaccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}

    
}
