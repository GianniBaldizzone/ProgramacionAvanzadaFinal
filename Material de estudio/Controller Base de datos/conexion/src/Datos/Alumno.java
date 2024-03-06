package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Alumno extends Persona{


	private int NroAlumno;
	
	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public int getNroAlumno() {
		return NroAlumno;
	}

	
	





	@Override
	public String toString() {
		return "Alumno [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
				+ "]";
	}








	public void setNroAlumno(int nroAlumno) {
		NroAlumno = nroAlumno;
	}

	
	public Alumno(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	public Alumno(){
		super();
	}
	
	public boolean guardarAlumno(Alumno alumno) {
		
		String sql ="INSERT INTO `persona`(`dni`, `nombre`, `apellido`, `rol`) VALUES (?,?,?,?)"; 
	
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1,alumno.getDni());
			stmt.setString(2,alumno.getNombre());
			stmt.setString(3,alumno.getApellido());
			stmt.setInt(4,alumno.getNroAlumno());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
	}
	
	
	public boolean ActualizarAlumno(Alumno alumno) {
		
		String sql ="UPDATE `persona` SET `nombre`='?',`apellido`='?',`rol`='?' WHERE dni='?' ";

	
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1,alumno.getNombre());
			stmt.setString(2,alumno.getApellido());
			stmt.setInt(3,alumno.getNroAlumno());
			stmt.setString(4,alumno.getDni());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
	}
	public LinkedList<Alumno>  ListaAl(Alumno alumno) {
		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();
		String sql ="SELECT * FROM `persona`"; 
		
		String[] datos = new String[4];
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			ResultSet result =  stmt.executeQuery();
			
			while(result.next()) {
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = result.getString(4);
				alumnos.add(new Alumno(datos[0],datos[1],datos[2]));
			}
		
			return alumnos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return alumnos;
		}
	}
	
	public boolean eliminar(Alumno alumno) {
		   String sql = "dDELETE FROM `persona` WHERE dni='?'";

		    try {
		    	stmt = conexion.prepareStatement(sql);
		    	int aux =  Integer. valueOf(alumno.getDni());
		      
		      stmt.setInt(1,aux);
		      stmt.executeUpdate();
		      return true;
		    } catch (Exception e) {
				// TODO: handle exception
				System.out.println("error ");
				return false;
			}
	}
	
}
