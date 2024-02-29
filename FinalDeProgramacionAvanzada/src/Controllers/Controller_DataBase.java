package Controllers;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Controller_DataBase {
	
	Connection con ;
	
	
	public Connection conectar() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con = 
	(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cajero","root","");
	System.out.println("Conexion a la base de datos exitosa");
	} catch (Exception e) {
	System.out.println("Error al conectarse a la base de datos");
	}
	return con; 
	}
	 
	public void desconectar() {
	        try {
	            if (con != null) {
	                con.close();
	                System.out.println("Desconexión de la base de datos exitosa");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar la conexión a la base de datos");
	            e.printStackTrace();
	        }
}
}

