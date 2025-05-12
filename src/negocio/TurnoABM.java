package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import dao.TurnoDao;
import datos.Cliente;
import datos.EstadoTurno;
import datos.Turno;

public class TurnoABM {
	private TurnoDao turnoDao = new TurnoDao();

	
	

//Caso de uso 7 

public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin) {
	 return turnoDao.traerTurnosEntreFechas(fechaInicio, fechaFin);
}
	
	
//Caso de uso 8

	public List<Turno> traerTurnosCliente(Cliente cliente, LocalDate fecha) {
		 return turnoDao.traerTurnosCliente(cliente, fecha);
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
        turno.setEstado(EstadoTurno.COMPLETADO.name());
    } else {
        turno.setEstado(EstadoTurno.CANCELADO.name());}

    turnoDao.actualizar(turno);
    System.out.println("Estado actualizado a: " + turno.getEstado());
}

//Caso de uso 3
	
	public List<Turno> traerTurnosDeEmpleado(int dniEmpleado) {
	    return turnoDao.traerPorEmpleado(dniEmpleado);
	}



public boolean  modificarTurno (int idTurno, LocalDate fecha, LocalDateTime horaTurno ){



    Turno turno = turnoDao.traer(idTurno);

    if (turno != null){
        turno.setFecha(fecha);
        turno.setHoraTurno(horaTurno);
        turnoDao.actualizar(turno);

        System.out.println("Turno modificado exitosamente.");

        return true;

    }else{
        return false;
    }}




public boolean cancelarTurno(int id, Cliente solicitante, boolean esEmpleado) {

Turno turno = turnoDao.traer(id);

// Validar que el turno exista

if (turno != null) {
    
    if (esEmpleado || turno.getCliente().equals(solicitante)) {
        turno.setEstado(EstadoTurno.CANCELADO.name());
        turnoDao.actualizar(turno);
        System.out.println("Turno cancelado exitosamente.");
        return true;
    } else {
        System.out.println("Permiso denegado para cancelar el turno.");
        return false;
    }
    } else {
        System.out.println("El turno no existe.");
        return false;
    }
}}