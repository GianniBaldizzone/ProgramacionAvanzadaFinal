package Controllers;

import java.sql.DriverManager;

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

}

