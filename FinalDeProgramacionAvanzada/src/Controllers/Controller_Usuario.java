package Controllers;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Modelo.Usuario;

public class Controller_Usuario {
	private Connection conexion;

    public Controller_Usuario(Connection conexion) {
        this.conexion =  conexion;
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre, apellido, mail, telefono, direccion, dni) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getMail());
            stmt.setString(4, usuario.getTelefono());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getDni());
            stmt.executeUpdate();
        }
        
        
    }
    public void eliminarUsuario(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void modificarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre = ?, apellido = ?, mail = ?, telefono = ?, direccion = ?, dni = ? WHERE id = ?";
        try (PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getMail());
            stmt.setString(4, usuario.getTelefono());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getDni());
            stmt.setInt(7, usuario.getId());
            stmt.executeUpdate();
        }
    }
}
