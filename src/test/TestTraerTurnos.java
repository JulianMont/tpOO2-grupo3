package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Turno;
import negocio.TurnoABM;

public class TestTraerTurnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TurnoABM abm = new TurnoABM();
		
		
		//EN CASO DE ERROR PARA EJECUTAR, EN HIBERNATE CONFIG DONDE DICE CREATE/UPDATE 
		//PONER CREATE Y LUEGO EJECUTAR LLENARDB
		//CAMBIAR CREATE POR UPDATE 
		
        LocalDate fechaInicio = LocalDate.of(2025, 5, 12);
        LocalDate fechaFin = LocalDate.of(2025, 5, 13);
		
		List<Turno> listaTurnos = abm.traerTurnos(fechaInicio, fechaFin);
		
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
		
		System.out.println("OK");

	}
}