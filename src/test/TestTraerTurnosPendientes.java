package test;

import java.time.LocalDate;
import java.util.List;

import datos.Turno;
import negocio.TurnoABM;

public class TestTraerTurnosPendientes {

	public static void main(String[] args) {
		TurnoABM turnoAbm = new TurnoABM();
    	
       
        
        
        
        try {
        	
        	List<Turno> turnos = turnoAbm.traerTurnosPendientesTalDia(LocalDate.of(2025, 06, 16));
        	System.out.println("---CASO DE USO 5: TRAER TURNOS PENDIENTES EN UN DIA-- ");
        	

        	// Mostrar los turnos
            for (Turno t : turnos) {
                System.out.println("Turno ID: " + t.getIdTurno() + " | Estado: " + t.getEstado());
        }} catch (Exception e) {
            e.printStackTrace();
        }

	}
}
