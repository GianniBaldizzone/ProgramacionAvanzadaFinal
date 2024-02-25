package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;
import Modelo.Usuario;

public class main {

	public static void main(String[] args) {
		
		 Controller_DataBase conexion = new Controller_DataBase();
	     conexion.conectar();
	
		Controller_Usuario usuarioController = new Controller_Usuario(conexion.conectar());

        // Crear un nuevo usuario
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
