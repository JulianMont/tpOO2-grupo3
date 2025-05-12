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
		
		//EN CASO DE ERROR PARA EJECUTAR, EN HIBERNATE CONFIG DONDE DICE CREATE/UPDATE 
		//PONER CREATE Y LUEGO EJECUTAR LLENARDB
		//CAMBIAR CREATE POR UPDATE 
		
		Cliente cliente1 = clienteABM.traer(33123456);
        LocalDate fecha = LocalDate.now();
        
        
        List<Turno> listaTurnos = turnoABM.traerTurnosCliente(cliente1, fecha); 
        
        System.out.println("Turnos encontrados para el cliente " + cliente1.getNombre() + " en la fecha " + fecha + ":");
        if (listaTurnos != null && !listaTurnos.isEmpty()) {
            for (Turno turno : listaTurnos) {
                System.out.println("==========================================");
                System.out.println(turno);
                System.out.println("==========================================\n");
            }
        } else {
            System.out.println("No se encontraron turnos para el cliente " + cliente1.getNombre() + " en la fecha " + fecha);
        }
		

		System.out.println("OK");
	}

}
