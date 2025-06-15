package test;

import java.time.LocalDate;
import java.util.List;

import datos.Empleado;
import datos.Turno;
import negocio.EmpleadoABM;
import negocio.TurnoABM;

public class TestTraerTurnosEmpleadosXFecha {

	public static void main(String[] args) {
		TurnoABM turnoABM = new TurnoABM();
		EmpleadoABM empleadoABM = new EmpleadoABM();
		 
		try {
			
			Empleado empleado = empleadoABM.traer(30211222);
			
			//El cliente tiene turno en plus 0 y 7
	        LocalDate fecha = LocalDate.now().plusDays(7);
	        
	        
	        List<Turno> listaTurnos = turnoABM.traerTurnosEmpleadoPorFecha(empleado.getIdPersona(), fecha); 
	        
			System.out.println("CU11 - Ver Turnos del Empleado en X fecha");
	        System.out.println("Este test muestra por consola la lista de turnos de un empleado en una fecha determinada\n");
	        System.out.println("==========================================\n\n");
	        
	        if (listaTurnos != null && !listaTurnos.isEmpty()) {
	            System.out.println("Turnos encontrados para el empleado " + empleado.getNombre() + " en la fecha " + fecha + ":");
	            for (Turno turno : listaTurnos) {
	                System.out.println("==========================================");
	                System.out.println(turno);
	                System.out.println("==========================================\n");
	            }
	        } else {
	            System.out.println("No se encontraron turnos para el empleado " + empleado.getNombre() + " en la fecha " + fecha);
	        }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		

		System.out.println("OK");
	

	}

}
