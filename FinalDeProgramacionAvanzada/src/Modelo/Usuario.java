package Modelo;

public class Usuario {
	 private int id;
	    private String nombre;
	    private String apellido;
	    private String mail;
	    private String telefono;
	    private String direccion;
	    private String dni;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public Usuario(int id, String nombre, String apellido, String mail, String telefono, String direccion,
				String dni) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.mail = mail;
			this.telefono = telefono;
			this.direccion = direccion;
			this.dni = dni;
		}
	    
		public Usuario() {
			super();
			
		}
}
