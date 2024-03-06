package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private int rol; 
	
	public Persona(String nombre, String apellido, String dni, int rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.rol = rol;
	}
	
	public Persona() {
		
	}
	
	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	
	public boolean guardar() {

		String sql = "INSERT INTO `persona`(`nombre`, `apellido`, `dni`, `rol`) VALUES (?,?,?,?)";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getDni());
			stmt.setLong(4, this.getRol());
			
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	public boolean editar() {

		String sql = "UPDATE `persona` SET `nombre`=?,`apellido`=?,`rol`=? WHERE dni = ?";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setLong(3, this.getRol());
			stmt.setString(4, this.getDni());
			
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	public boolean Eliminar() {

		String sql = "DELETE FROM `persona` WHERE dni=?";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getDni());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	
	public LinkedList<Persona> Mostrar() {
		LinkedList<Persona> personas = new LinkedList<Persona>();
		String sql = "SELECT * FROM `persona` WHERE 1";
		
		String[] datos = new String[4];
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			ResultSet resultados =	stmt.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				personas.add(new Persona(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			if(personas.isEmpty()) {
				
				return null;
			}else {
				
				return personas;
			}
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return null;
		}
		
		
	}
	
	
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", rol=" + rol + "]";
	}

	
	
	
	
}
