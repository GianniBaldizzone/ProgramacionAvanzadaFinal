package Controllers;

import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Modelo.Transaccion;

public class Controller_Transaccion {

	
	
	private Connection conexion;

    public Controller_Transaccion(Connection conexion) {
        this.conexion =  conexion;
    }
	
	
	public void generarTransaccion(Transaccion transaccion) {
        try {
            String query = "INSERT INTO transaccion (fecha_transaccion, cuenta_id, monto, tipo) VALUES (?, ?, ?, ?)";
           
			PreparedStatement statement = (PreparedStatement) conexion.prepareStatement(query);
            statement.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            statement.setInt(2, transaccion.getCuentaId());
            statement.setDouble(3, transaccion.getMonto());
            statement.setString(4, transaccion.getTipo().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	
}
