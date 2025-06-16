package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Turno;
import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestTraerTurnosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TurnoABM turnoABM = new TurnoABM();
		ClienteABM clienteABM = new ClienteABM();
		 
		try {
			
			Cliente cliente1 = clienteABM.traer(33123456);
			
			//El cliente tiene turno en plus 0 y 4
	        LocalDate fecha = LocalDate.now().plusDays(4);
	        
	        
	        List<Turno> listaTurnos = turnoABM.traerTurnosCliente(cliente1.getIdPersona(), fecha); 
	        
			System.out.println("CU8 - Ver Turnos del Cliente en X fecha");
	        System.out.println("Este test muestra por consola la lista de turnos de un cliente en una fecha determinada\n");
	        System.out.println("==========================================\n\n");
	        
	        if (listaTurnos != null && !listaTurnos.isEmpty()) {
	            System.out.println("Turnos encontrados para el cliente " + cliente1.getNombre() + " en la fecha " + fecha + ":");
	            for (Turno turno : listaTurnos) {
	                System.out.println("==========================================");
	                System.out.println(turno);
	                System.out.println("==========================================\n");
	            }
	        } else {
	            System.out.println("No se encontraron turnos para el cliente " + cliente1.getNombre() + " en la fecha " + fecha);
	        }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		

		System.out.println("OK");
	}

}
