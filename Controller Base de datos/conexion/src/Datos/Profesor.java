package Datos;

public class Profesor extends Persona{
	
	private int nrolegajo;

	public int getNrolegajo() {
		return nrolegajo;
	}

	public void setNrolegajo(int nrolegajo) {
		this.nrolegajo = nrolegajo;
	}

	
	public Profesor(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	public Profesor() {
		super();
	}
	
	
}
