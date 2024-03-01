package Modelo;

import java.sql.Date;

public class Depositar extends Transaccion{

	public Depositar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depositar(int id, Date fechaTransaccion, int cuentaId, double monto, TipoTransaccion tipo) {
		super(id, fechaTransaccion, cuentaId, monto, tipo);
		// TODO Auto-generated constructor stub
	}

}
