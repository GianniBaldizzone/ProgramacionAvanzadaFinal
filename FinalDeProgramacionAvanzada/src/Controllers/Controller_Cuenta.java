package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Cuenta;

public class Controller_Cuenta {
	


	    
	    private Connection connection;
	    
	    public Controller_Cuenta(Connection connection) {
	        this.connection = connection;
	    }
	    
	    public boolean altaCuenta(Cuenta cuenta) {
	        try {
	            String query = "INSERT INTO cuenta (numero_cuenta, saldo, pin, tipo_cuenta, usuario_id) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(query);
	            
	            // Generar un número de cuenta único de 10 dígitos
	            int numeroCuenta = generarNumeroCuentaUnico();
	            cuenta.setNumeroCuenta(numeroCuenta);

	            statement.setInt(1, cuenta.getNumeroCuenta());
	            statement.setDouble(2, cuenta.getSaldo());
	            statement.setString(3, cuenta.getPin());
	            statement.setString(4, cuenta.getTipoCuenta().toString());
	            statement.setInt(5, cuenta.getUsuarioId());

	            int rowsInserted = statement.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    private int generarNumeroCuentaUnico() {
	        int numeroCuenta;
	        boolean numeroRepetido;

	        // Generar un número de cuenta único de 10 dígitos
	        do {
	        	numeroCuenta = (int) (Math.random() * 900000000) + 1000000000; // Genera un número aleatorio de 10 dígitos
	            numeroRepetido = verificarNumeroRepetido(numeroCuenta);
	        } while (numeroRepetido);

	        return numeroCuenta;
	    }

	    private boolean verificarNumeroRepetido(int numeroCuenta) {
	    	try {
	            String query = "SELECT COUNT(*) AS count FROM cuenta WHERE numero_cuenta = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, numeroCuenta);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                int count = resultSet.getInt("count");
	                return count > 0; // Si count es mayor que cero, significa que el número de cuenta está repetido
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false; // Si hubo algún error o el número de cuenta no está repetido, retornamos false
	    }
	    
	    public boolean bajaCuenta(int idCuenta) {
	        try {
	            String query = "DELETE FROM cuenta WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, idCuenta);
	            int rowsDeleted = statement.executeUpdate();
	            return rowsDeleted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public boolean modificarPin(int idCuenta, String nuevoPin) {
	        try {
	            String query = "UPDATE cuenta SET pin = ? WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, nuevoPin);
	            statement.setInt(2, idCuenta);
	            int rowsUpdated = statement.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}

