package datos;

public class Persona {
	private String nombre;
	private String apellido;
	private long dni;
	private String email;
	private String movil;
	private String telefono;
	
	public Persona() {
		
	}
	
	
	public Persona(String nombre, String apellido, long dni, String email, String movil, String telefono) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.movil = movil;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public long getDni() {
		return dni;
	}


	protected void setDni(long dni) {
		this.dni = dni;
	}


	public String getEmail() {
		return email;
	}


	protected void setEmail(String email) {
		this.email = email;
	}


	public String getMovil() {
		return movil;
	}


	protected void setMovil(String movil) {
		this.movil = movil;
	}


	public String getTelefono() {
		return telefono;
	}


	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", movil="
				+ movil + ", telefono=" + telefono + "]";
	}


	
}
