package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Comparator;

import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.stream.Collectors;

import dao.TurnoDao;
import datos.Empleado;
import datos.EstadoTurno;
import datos.Persona;
import datos.Servicio;
import datos.Turno;
import helpers.EmpleadoRanking;

public class TurnoABM {
	
	private TurnoDao turnoDao = new TurnoDao();

	

//Caso de uso 7 

public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin) throws Exception {
	
    if (fechaInicio == null || fechaFin == null) {
        throw new IllegalArgumentException("Las fechas no pueden ser nulas");
    }
    if (fechaInicio.isAfter(fechaFin)) {
        throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
    }
	 return turnoDao.traerTurnosEntreFechas(fechaInicio, fechaFin);
}
	
	
//Caso de uso 8

	public List<Turno> traerTurnosCliente(int idCliente, LocalDate fecha) throws Exception {
		
	    if (fecha == null) {
	        throw new IllegalArgumentException("La fecha no puede ser nula");
	    }
		 return turnoDao.traerTurnosCliente(idCliente, fecha);
	}
		
		
	public Turno traer(int idTurno) {
		Turno t= turnoDao.traer(idTurno);
		return t;}
	
	public int agregar(Turno t) throws Exception {
	    if (traer(t.getIdTurno()) != null) {
	        throw new Exception("Ya existe un turno con ese id " + t.getIdTurno());
	    }
	    return turnoDao.agregar(t);
	}
	
	

//Caso de uso 6
	
	public void completarTurno(int idTurno, boolean fueAtendido) throws Exception {
    Turno turno = turnoDao.traer(idTurno);
    if (turno == null) {
        throw new Exception("Turno no encontrado con ID: " + idTurno);
    }

    if (fueAtendido) {
        turno.setEstado(EstadoTurno.COMPLETADO);
    } else {
        turno.setEstado(EstadoTurno.CANCELADO);}

    turnoDao.actualizar(turno);
    System.out.println("Estado actualizado a: " + turno.getEstado());
}

//Caso de uso 3
	
	public List<Turno> traerTurnosDeEmpleado(int dniEmpleado) {
	    return turnoDao.traerPorEmpleado(dniEmpleado);
	}
	
	

//caso de uso 10
	
	public List<Turno> traerTurnosCompletadosCliente(Cliente cliente){
		
		return turnoDao.traerTurnosCompletadosCliente(cliente, EstadoTurno.COMPLETADO);
	}

	
	public List<Turno> traerTurnosCompletadosCliente(Cliente cliente){
		
		return turnoDao.traerTurnosCompletadosCliente(cliente, EstadoTurno.COMPLETADO);
	}

	// ---- Caso de Uso 1 ----
    
    // Verificar si existe el turno
    
    public boolean existeTurno (Empleado empleado, LocalDate dia, LocalDateTime horaTurno) {
    	
    	List<Turno> turnosEnMismoHorario = turnoDao.traerTurnosPorEmpleadoFechaHora(empleado.getDni(), dia, horaTurno);
        return !turnosEnMismoHorario.isEmpty();
    	
    }
    
    // Reservar el Turno
    
    public Turno reservarTurno(LocalDate fecha, LocalDateTime horaTurno, Cliente cliente, Empleado empleado, Set<Servicio> servicio) throws Exception {
        
        if (existeTurno(empleado, fecha, horaTurno)) {
            throw new Exception("Ya existe un turno para ese empleado en esa fecha y hora.");
        }

        // Construcción del objeto Turno
        Turno turno = new Turno();
        turno.setCliente(cliente);
        turno.setEmpleado(empleado);
        turno.setServicios(servicio);
        turno.setFecha(fecha);
        turno.setHoraTurno(horaTurno);
        turno.setEstado(EstadoTurno.EN_PROCESO);

        // Guardado en base de datos
        int id = turnoDao.agregar(turno);
        turno.setIdTurno(id);

        return turno;
    }
    
    
    // ---- Caso de uso 2 ----
    
    // Cancelar el Turno

	public boolean cancelarTurno(int id, Persona solicitante, boolean esEmpleado) {
		
		
		if (!esEmpleado && solicitante == null) {
	        System.out.println("Error: solicitante null cuando se espera un cliente.");
	        return false;
	    }
	    
		Turno turno = turnoDao.traer(id);
		
		
		if (turno != null) {
		    
			if (esEmpleado) {
			    turno.setEstado(EstadoTurno.CANCELADO);
			    turnoDao.actualizar(turno);
			    System.out.println("El empleado ha cancelado el turno.");
			    return true;
			} else if (turno.getCliente().getIdPersona() == solicitante.getIdPersona()) {
			    turno.setEstado(EstadoTurno.CANCELADO);
			    turnoDao.actualizar(turno);
			    System.out.println("El cliente ha cancelado su turno.");
			    return true;
			}
	    } else {
	        System.out.println("El turno no existe.");
	       
	    }
		
		 return false;
		
	}
    
    // ---- Caso de Uso 4 ----
    
	// Modificar la Fecha y Hora del Turno

	public boolean  modificarTurnoPorDiaYHora (int idTurno, LocalDate fecha, LocalDateTime horaTurno ){
		
	    Turno turno = turnoDao.traer(idTurno);
	    
	    if(turno == null) {
	    	System.out.println("No existe el turno con ese ID.");
	    	return false;
	    }
	    
        turno.setFecha(fecha);
        turno.setHoraTurno(horaTurno);
        turnoDao.actualizar(turno);

        System.out.println("Turno modificado exitosamente.");

        return true;
	    
	}
	
	//Caso de uso 5
		public List<Turno> traerTurnosPendientesTalDia (LocalDate fecha){
			return turnoDao.traerTurnosPendientesTalDia(EstadoTurno.EN_PROCESO, fecha);
		} 
	
    //  ---- Caso de Uso 9 ----
	
	public void imprimirReporteCancelados(List<Turno> turnosCancelados) {
	    System.out.println("Reporte de Turnos Cancelados:");
	    for (Turno t : turnosCancelados) {
	        System.out.println("ID: " + t.getIdTurno() + ", Cliente: " + t.getCliente().getNombre() 
	            + ", Fecha: " + t.getFecha() + ", Hora: " + t.getHoraTurno() 
	            + ", Servicio: " + t.getServicios());
	    }
	}
	
	//Caso de uso 11

		public List<Turno> traerTurnosEmpleadoPorFecha(int idEmpleado, LocalDate fecha) throws Exception {
			
		    if (fecha == null) {
		        throw new IllegalArgumentException("La fecha no puede ser nula");
		    }
			 return turnoDao.traerTurnosEmpleado(idEmpleado, fecha);
		}
		
	//CU 12
	    
	    public List<EmpleadoRanking> generarRankingMensual (int mes,int anio)  throws Exception {
	    	
	    	LocalDate fechaInicio = LocalDate.of(anio,mes,1);
	    	LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());
	    	
	    	List<Turno> turnosDelMes = traerTurnos(fechaInicio, fechaFin);
	    	
	    	//agrupo por empleado los turnos y voy sumando la cantidad de turnos
	        Map<Empleado, Long> turnosPorEmpleado = turnosDelMes.stream()
	                .collect(Collectors.groupingBy(Turno::getEmpleado, Collectors.counting()));


	        //genero la lista y la devuelvo
	        return turnosPorEmpleado.entrySet().stream()
	                .map(entry -> new EmpleadoRanking(entry.getKey(), entry.getValue()))
	                .sorted(Comparator.comparingLong(EmpleadoRanking::getCantidadTurnos).reversed())
	                .toList();
	    	
	    }
	    
	
	
	
}
