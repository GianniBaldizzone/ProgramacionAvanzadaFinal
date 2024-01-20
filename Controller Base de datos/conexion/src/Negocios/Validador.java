package Negocios;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.Persona;

public class Validador {

	Persona Verificador = new Persona();
	
	public boolean ValidarIngreso(String nombre,String apellido,String dni,int rol) {
		
		
		if (nombre.length()==0) {
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			return false;
		}else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setDni(dni);
			Verificador.setRol(rol);
			if( Verificador.guardar()) {
				return true;
			}else {
				return false;
			}
		}

	}
	
public boolean ValidarEditar(String nombre,String apellido,String dni,int rol) {
		
		
		if (nombre.length()==0) {
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			return false;
		}else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setDni(dni);
			Verificador.setRol(rol);
			if( Verificador.editar()) {
				return true;
			}else {
				return false;
			}
		}

	}
public boolean ValidarEliminar(String dni) {
	
	
	if (dni.length()==0) {
		JOptionPane.showMessageDialog(null, "dni vacio");
		return false;
	}else {
		Verificador.setDni(dni);
		if( Verificador.Eliminar()) {
			return true;
		}else {
			return false;
		}
	}

}
	public LinkedList<Persona> Mostrar() {
		
		return Verificador.Mostrar();
	}

}
