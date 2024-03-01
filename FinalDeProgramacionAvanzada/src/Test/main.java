package Test;
import GUI.Login;

import java.sql.Connection;
import java.sql.SQLException;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;
import Modelo.Cuenta;
import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;
import Modelo.TipoCuenta;
import Modelo.Usuario;

public class main {

	public static void main(String[] args) {
		
		/*Controller_DataBase conexion = new Controller_DataBase();
	    
		// Crear una instancia del controlador
        Controller_Cuenta cuentaController = new Controller_Cuenta(conexion.conectar());
        
        // Crear un objeto de cuenta para agregar
        Cuenta cuentaahorro = new CuentaAhorro(0, 123456789, 1000.0, "1234", 1);
        Cuenta cuentacorriente = new CuentaCorriente(0, 123456789, 1000.0, "1234", 1);
        
        // Probar el método altaCuenta
     

            // Prueba de alta de cuenta
            boolean altaExitosa = cuentaController.altaCuenta(cuentacorriente);
            if (altaExitosa) {
                System.out.println("Se ha agregado la cuenta correctamente.");
            } else {
                System.out.println("Error al agregar la cuenta.");
            }
    
        
        
	*/
		
		Login frame = new Login();
		frame.setVisible(true);
	
	}}
       



















/* Crear un nuevo usuario
 * 
 * Controller_Usuario usuarioController = new Controller_Usuario(conexion.conectar());
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Gamaliel");
        nuevoUsuario.setApellido("Quiroz");
        nuevoUsuario.setMail("gamaliel@example.com");
        nuevoUsuario.setTelefono("123456789");
        nuevoUsuario.setDireccion("Calle Principal");
        nuevoUsuario.setDni("12345678");

        // Intentar agregar el nuevo usuario a la base de datos
        try {
            usuarioController.agregarUsuario(nuevoUsuario);
            System.out.println("Usuario agregado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }
	}

}
*/
