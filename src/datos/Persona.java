package datos;

public abstract class Persona {
	protected int idPersona;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected String email;
	protected String movil;
	protected String telefono;

	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, int dni, String email, String movil, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.movil = movil;
		this.telefono = telefono;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
	    return nombre + " " + apellido + " (DNI: " + dni + ", Email: " + email +
	           ", Móvil: " + movil + ", Tel: " + telefono + ")";
	}

	
}
