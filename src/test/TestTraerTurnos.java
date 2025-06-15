package test;

import java.time.LocalDate;
import java.util.List;

import datos.Turno;
import negocio.TurnoABM;

public class TestTraerTurnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TurnoABM abm = new TurnoABM();
		
		try {
		
	        LocalDate fechaInicio = LocalDate.now().plusDays(2);
	        LocalDate fechaFin = LocalDate.now().plusDays(4);
			
			List<Turno> listaTurnos = abm.traerTurnos(fechaInicio, fechaFin);
			
			System.out.println("CU7 - Ver Turnos entre X Fechas");
	        System.out.println("Este test muestra por consola la lista de turnos entre 2 fechas\n");
	        System.out.println("==========================================\n\n");
			
			if (listaTurnos != null && !listaTurnos.isEmpty()) {
			    System.out.println("Lista de Turnos entre " + fechaInicio + " y " + fechaFin + ":");
			    
			    for (Turno turno : listaTurnos) {
			        System.out.println("==========================================");
			        System.out.println(turno);
			        System.out.println("==========================================\n");
			    }
			} else {
			    System.out.println("No se encontraron turnos en el rango de fechas especificado.");
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		System.out.println("OK");

	}
}