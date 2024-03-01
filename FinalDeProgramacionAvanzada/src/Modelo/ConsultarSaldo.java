package Modelo;

import java.sql.Date;

public class ConsultarSaldo extends Transaccion{

	public ConsultarSaldo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsultarSaldo(int id, Date fechaTransaccion, int cuentaId, double monto, TipoTransaccion tipo) {
		super(id, fechaTransaccion, cuentaId, monto, tipo);
		// TODO Auto-generated constructor stub
	}

}
