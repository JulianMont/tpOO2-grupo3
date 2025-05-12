package datos;

import java.util.Set;

public class Cliente extends Persona {

	private Set<Turno> turnos;
	private boolean estado;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int dni, String email, String movil, String telefono, Set<Turno> turnos, boolean estado) {
		super(nombre, apellido, dni, email, movil, telefono);
		this.turnos = turnos;
		this.estado = estado;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	protected void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public boolean isEstado() {
		return estado;
	}

	protected void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente: " +  super.toString() + " | Estado: " + estado;
	}
	
	

	
}
