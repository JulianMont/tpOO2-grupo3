package datos;

import java.util.Set;

public class Servicio {
	protected int idServicio;
	private String nombre;
	private String descripcion;
	
	private Set<Turno> turnos;
	
	
	public Servicio() {
		super();
	}

	public Servicio(int idServicio, String nombre, String descripcion, Set<Turno> turnos) {
		super();
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.turnos = turnos;
	}
	
	public Servicio(int idServicio, String nombre, String descripcion) {
		super();
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	public Servicio(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
	    return nombre + " (ID: " + idServicio + ") - " + descripcion;
	}


	
	
}
