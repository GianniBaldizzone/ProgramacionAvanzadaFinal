package Modelo;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Conexion {
	Connection con ;
	public Connection conectar() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con = 
	(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cajero","root","");
	JOptionPane.showMessageDialog(null, "Conexion a la base de datos exitosa");
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
	}
	return con; 
	}

}
