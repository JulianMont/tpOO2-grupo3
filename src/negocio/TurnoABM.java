package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.Exception;
import dao.TurnoDao;
import datos.Cliente;
import datos.Turno;

public class TurnoABM {
	private TurnoDao turnoDao = new TurnoDao();

	public List<Turno> getTurnosDeEmpleado(int idEmpleado) {
	 return turnoDao.obtenerTurnosPorEmpleado(idEmpleado);
	    }
	

//Caso de uso 7 

public List<Turno> traerTurnos(LocalDate fechaInicio,LocalDate fechaFin) {
	 return turnoDao.traerTurnosEntreFechas(fechaInicio, fechaFin);
	    }
	
	
//Caso de uso 8

	public List<Turno> traerTurnosCliente(Cliente cliente, LocalDate fecha) {
		 return turnoDao.traerTurnosCliente(cliente, fecha);
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
        turno.setEstado(EstadoTurno.CANCELADO);

        turnoDao.actualizar(turno);
        System.out.println("Estado actualizado a: " + turno.getEstado());
    	}
	}
}

