package test;

import java.util.List;

import helpers.EmpleadoRanking;
import negocio.TurnoABM;

public class TestGenerarRankingMensual {

	public static void main(String[] args) {
		
		
		TurnoABM turnoABM = new TurnoABM();
		
	try {
	        
        
	        int mes = 6 ;
	        int anio = 2025 ;
	        
	        
	        List<EmpleadoRanking> empleadosRanking = turnoABM.generarRankingMensual(mes, anio);
	        
			System.out.println("CU12 - Generar Ranking Mensual");
	        System.out.println("Este test muestra por consola una lista de empleados ordenada de mayor a menor segun la cantidad de turnos \n");
	        System.out.println("==========================================\n\n");
			
	        for(EmpleadoRanking empleado : empleadosRanking) {
	            System.out.println("==========================================");
	            System.out.println(empleado);
	            System.out.println("==========================================\n");
	        }
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		// TODO: handle exception
	}
	

	}

}
