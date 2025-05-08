package negocio;

import dao.Exception;
import dao.TurnoDao;


import datos.Cliente;
import datos.EstadoTurno;
import datos.Turno;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TurnoABM {
	private TurnoDao turnoDao = new TurnoDao();

    
	public List<Turno> getTurnosDeEmpleado(int idEmpleado) { return turnoDao.obtenerTurnosPorEmpleado(idEmpleado);}
	

        public boolean  modificarTurno (int idTurno, LocalDate fecha, LocalDateTime horaTurno, ){



            Turno turno = turnoDao.buscarPorId(idTurno);

            if (turno != null){
                turno.setFecha(fecha);
                turno.setHoraTurno(horaTurno);
                turnoDAO.actualizar(turno);

                System.out.println("Turno modificado exitosamente.");

                return true;

            }else{
                return false;
            }


        }
	
        public boolean cancelarTurno(int id, Cliente solicitante, boolean esEmpleado) {
        Turno turno = turnoDAO.buscarPorId(id);

        // Validar que el turno exista
        if (turno != null) {
            
            if (esEmpleado || turno.getCliente().equals(solicitante)) {
                turno.setEstadoTurno(EstadoTurno.CANCELADO);
                turnoDAO.actualizar(turno);
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



