package Controllers;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class Controller_DataBase {

	
	


Connection con ;
			
			public Connection conectar() {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alohanet","root","jaimito");
					//JOptionPane.showMessageDialog(null, "se conecto");
				} catch (Exception e) {
			
					JOptionPane.showMessageDialog(null, "error al conectarse");
				}
				return con;
			}
		
	}


