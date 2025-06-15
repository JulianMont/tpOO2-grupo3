package test;


import dao.PersonaDao;
import datos.Persona;
import negocio.TurnoABM;

public class TestCancelarTurno {

    public static void main(String[] args) {
    	
        TurnoABM turnoABM = new TurnoABM();

        int idTurno = 3;
        int idCliente = 3;
        
        PersonaDao personaDao = new PersonaDao();
        Persona solicitante = personaDao.traer(idCliente);
        
        boolean esEmpleado = false;
        
        boolean cancelado = turnoABM.cancelarTurno(idTurno, solicitante, esEmpleado);

        
        if(cancelado) {
            System.out.println("Turno cancelado exitosamente.");
        } else {
            System.out.println("No se pudo cancelar el turno.");
        }
    }
    
}