package Modelo;

import java.sql.Date;

public class Tranferir extends Transaccion{

	public Tranferir() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tranferir(int id, Date fechaTransaccion, int cuentaId, double monto, TipoTransaccion tipo) {
		super(id, fechaTransaccion, cuentaId, monto, tipo);
		// TODO Auto-generated constructor stub
	}
	  
  
    
}

