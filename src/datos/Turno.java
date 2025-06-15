package datos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

public class Turno {
	protected int idTurno;
	private LocalDate fecha;
	private LocalDateTime horaTurno;
	private Cliente cliente;
	private Empleado empleado;
	private Set<Servicio> servicios;
	private EstadoTurno estado;
	
	public Turno() {
		super();
	}

	public Turno(LocalDate fecha, LocalDateTime horaTurno, Cliente cliente, Empleado empleado,
			Set<Servicio> servicios, EstadoTurno estado) {
		super();
		this.fecha = fecha;
		this.horaTurno = horaTurno;
		this.cliente = cliente;
		this.empleado = empleado;
		this.servicios = servicios;;
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

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	public EstadoTurno getEstado() {
	    return estado;
	}

	public void setEstado(EstadoTurno estado) {
	    this.estado = estado;
	}

	@Override
	public String toString() {
	    return "Turno #" + idTurno + "\n" +
	           "Fecha: " + fecha + " | Hora: " + horaTurno + " | Estado: " +estado+ "\n" +
	           cliente + "\n" +
	           empleado + "\n" +
	           "Servicios:\n" + servicios.stream()
	                                     .map(servicio -> " - " + servicio)
	                                     .collect(Collectors.joining("\n"));
	
		
}}
