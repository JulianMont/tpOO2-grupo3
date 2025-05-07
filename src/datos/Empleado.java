package datos;

import java.util.Set;

public class Empleado extends Persona {
	private String legajo;
	private String puesto;
	private Set<Turno> turnos;
	private boolean estado;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, int dni, String email, String movil, String telefono,
			String legajo, String puesto, Set<Turno> turnos, boolean estado) {
		super(nombre, apellido, dni, email, movil, telefono);
		this.legajo = legajo;
		this.puesto = puesto;
		this.turnos = turnos;
		this.estado = estado;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", puesto=" + puesto + ", turnos=" + turnos + ", estado=" + estado + "]";
	}
	

}
