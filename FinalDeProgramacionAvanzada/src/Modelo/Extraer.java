package Modelo;

import java.sql.Date;

public class Extraer extends Transaccion{

	public Extraer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Extraer(int id, Date fechaTransaccion, int cuentaId, double monto, TipoTransaccion tipo) {
		super(id, fechaTransaccion, cuentaId, monto, tipo);
		// TODO Auto-generated constructor stub
	}

}
