package Controllers;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Cuenta;
import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;
import Modelo.TipoCuenta;

public class Controller_Cuenta {
	


	    
	    private Connection connection;
	    
	    public Controller_Cuenta(Connection connection) {
	        this.connection = connection;
	    }
	    
	    public boolean autenticar(int numeroCuenta, int pin) {
	        try {
	            // Consulta para verificar la existencia de la cuenta
	            String query = "SELECT COUNT(*) AS count FROM cuenta WHERE numero_cuenta = ? AND pin = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, numeroCuenta);
	            statement.setInt(2, pin);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                int count = resultSet.getInt("count");
	                
	                return count > 0; // Si count es mayor que cero, la cuenta existe y la autenticación es exitosa
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false; // Si hubo algún error o la cuenta no existe, retornamos false
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
	    
	    public void extraerSaldo(Cuenta cuenta, int dineroAExtraer) {
	        try {
	            // Verificar si se obtuvo la cuenta
	            if (cuenta != null) {
	                double nuevoSaldo = cuenta.getSaldo() - dineroAExtraer;
	                
	                // Verificar si el nuevo saldo es válido según el tipo de cuenta
	                if (((cuenta.getTipoCuenta() == TipoCuenta.CUENTA_CORRIENTE) && nuevoSaldo >= -1000000) ||
	                    (cuenta.getTipoCuenta() == TipoCuenta.CAJA_DE_AHORRO && nuevoSaldo >= 0)) {
	                    
	                    String query = "UPDATE cuenta SET saldo = ? WHERE numero_cuenta = ?";
	                    PreparedStatement statement = connection.prepareStatement(query);
	                    statement.setDouble(1, nuevoSaldo);
	                    statement.setInt(2, cuenta.getNumeroCuenta());
	                    
	                    int rowsUpdated = statement.executeUpdate();
	                    if (rowsUpdated > 0) {
	                        JOptionPane.showMessageDialog(null, "Extracción exitosa");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al actualizar el saldo");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar la extracción");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró la cuenta");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void depositarSaldo(Cuenta cuenta, int dineroADepositar) {
	        try {
	            // Verificar si se obtuvo la cuenta
	            if (cuenta != null) {
	                double nuevoSaldo = cuenta.getSaldo() + dineroADepositar;
	                
	                // Verificar si el monto a depositar no excede el límite de 2,000,000
	                if (dineroADepositar <= 2000000) {
	                    String query = "UPDATE cuenta SET saldo = ? WHERE numero_cuenta = ?";
	                    PreparedStatement statement = connection.prepareStatement(query);
	                    statement.setDouble(1, nuevoSaldo);
	                    statement.setInt(2, cuenta.getNumeroCuenta());
	                    
	                    int rowsUpdated = statement.executeUpdate();
	                    if (rowsUpdated > 0) {
	                        JOptionPane.showMessageDialog(null, "Deposito exitoso");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al actualizar el saldo");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se puede depositar más de 2,000,000.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró la cuenta");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	        
	        public Cuenta obtenerCuentaPorNumeroDeCuenta(int numeroDeCuenta) {
	        	Cuenta cuenta = null;
	            try {
	                String query = "SELECT * FROM cuenta WHERE numero_cuenta = ?";
	                PreparedStatement statement = connection.prepareStatement(query);
	                statement.setInt(1, numeroDeCuenta);
	                ResultSet resultSet = statement.executeQuery();

	                if (resultSet.next()) {
	                	
	                	if(resultSet.getString("tipo_cuenta").equals("CAJA_DE_AHORRO")) {
	                	cuenta = new CuentaAhorro();
	                    cuenta.setId(resultSet.getInt("id"));
	                    cuenta.setNumeroCuenta(resultSet.getInt("numero_cuenta"));
	                    cuenta.setSaldo(resultSet.getDouble("saldo"));
	                    cuenta.setPin(resultSet.getString("pin"));
	                    cuenta.setTipoCuenta(TipoCuenta.CAJA_DE_AHORRO);
	                    cuenta.setUsuarioId(resultSet.getInt("usuario_id"));}
	                    
	                }else {
	                	
	                	cuenta = new CuentaCorriente();
	                    cuenta.setId(resultSet.getInt("id"));
	                    cuenta.setNumeroCuenta(resultSet.getInt("numero_cuenta"));
	                    cuenta.setSaldo(resultSet.getDouble("saldo"));
	                    cuenta.setPin(resultSet.getString("pin"));
	                    cuenta.setTipoCuenta(TipoCuenta.CUENTA_CORRIENTE);
	                    cuenta.setUsuarioId(resultSet.getInt("usuario_id"));
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return cuenta;
	        }
	        
	        
	        public void transferirSaldo(Cuenta cuentaOrigen, Cuenta cuentaDestino, int montoTransferencia) {
	            // Verificar si se obtuvo la cuenta origen y destino
	            if (cuentaOrigen != null && cuentaDestino != null) {
	                // Extraer saldo de la cuenta origen
	                extraerSaldo(cuentaOrigen, montoTransferencia);
	                
	                // Depositar saldo en la cuenta destino
	                depositarSaldo(cuentaDestino, montoTransferencia);
	                
	                JOptionPane.showMessageDialog(null, "Transferencia exitosa");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró una de las cuentas");
	            }
	        }
	}


