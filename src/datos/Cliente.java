package datos;

import java.util.List;

public class Cliente extends Persona {
	
	private int idCliente;
	private List<Turno> turnos;
	private boolean estado;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nombre, String apellido, long dni, String email, String movil, String telefono) {
		super(nombre, apellido, dni, email, movil, telefono);

	}
	
	public Cliente(int idCliente, List<Turno> turnos, boolean estado) {
		super();
		this.idCliente = idCliente;
		this.turnos = turnos;
		this.estado = estado;
	}
	public int getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
		return "Cliente [idCliente=" + idCliente + ", turnos=" + turnos + ", estado=" + estado + "]";
	}
	
	
	
}
