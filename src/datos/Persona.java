package datos;

public abstract class Persona {
	protected int idPersona;
	private String nombre;
	private String apellido;
	private int dni;
	private String email;
	private String movil;
	private String telefono;

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

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	protected void setDni(int dni) {
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
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", movil=" + movil + ", telefono=" + telefono + "]";
	}

}
