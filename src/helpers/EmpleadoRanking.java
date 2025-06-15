package helpers;

import datos.Empleado;

public class EmpleadoRanking {
	
	private Empleado empleado;
	private Long cantidadTurnos;
	
	public EmpleadoRanking(Empleado empleado, Long cantidadTurnos) {
		super();
		this.empleado = empleado;
		this.cantidadTurnos = cantidadTurnos;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Long getCantidadTurnos() {
		return cantidadTurnos;
	}
	public void setCantidadTurnos(Long cantidadTurnos) {
		this.cantidadTurnos = cantidadTurnos;
	}
	
	@Override
	public String toString() {
		return empleado.getNombre() + " " + empleado.getApellido() + " - Turnos Atendidos: " + cantidadTurnos;
	}
	
	
	
	

}
