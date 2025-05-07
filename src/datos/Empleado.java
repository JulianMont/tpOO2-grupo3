package datos;

import java.util.List;

public class Empleado extends Persona {
	
	private int idEmpleado;
	private String legajo;
	private String puesto;
	private List<Turno> turnos;
	private boolean estado;

	
	public Empleado(String nombre, String apellido, long dni, String email, String movil, String telefono) {
		super(nombre, apellido, dni, email, movil, telefono);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
