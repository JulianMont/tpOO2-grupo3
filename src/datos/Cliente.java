package datos;

import java.util.List;

public class Cliente extends Persona {

	private List<Turno> turnos;
	private boolean estado;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, long dni, String email, String movil, String telefono, List<Turno> turnos, boolean estado) {
		super(nombre, apellido, dni, email, movil, telefono);
		this.turnos = turnos;
		this.estado = estado;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	protected void setTurnos(List<Turno> turnos) {
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
		return "Cliente [turnos=" + turnos + ", estado=" + estado + "]";
	}

}
