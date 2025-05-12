package datos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Turno {
	protected int idTurno;
	private LocalDate fecha;
	private LocalDateTime horaTurno;
	private Cliente cliente;
	private Empleado empleado;
	private Servicio servicio;
	private String estado;
	
	public Turno() {
		super();
	}

	public Turno(LocalDate fecha, LocalDateTime horaTurno, Cliente cliente, Empleado empleado,
			Servicio servicio, String estado) {
		super();
		this.fecha = fecha;
		this.horaTurno = horaTurno;
		this.cliente = cliente;
		this.empleado = empleado;
		this.servicio = servicio;
		this.estado = estado;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHoraTurno() {
		return horaTurno;
	}

	public void setHoraTurno(LocalDateTime horaTurno) {
		this.horaTurno = horaTurno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", horaTurno=" + horaTurno + ", cliente=" + cliente
				+ ", empleado=" + empleado + ", servicio=" + servicio + ", estado=" + estado + "]";
	}
	
		
}
