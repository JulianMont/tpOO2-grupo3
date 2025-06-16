package test;

import java.util.List;

import datos.Cliente;
import datos.Turno;
import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestTraerTurnosCompletadosCliente {

	public static void main(String[] args) {
		TurnoABM abm = new TurnoABM();
		ClienteABM clienteAbm = new ClienteABM();
		
		List<Turno> turnos = abm.traerTurnosCompletadosCliente(clienteAbm.traer(33556677));
		
		Cliente cliente = clienteAbm.traer(33556677);
		System.out.printf("CASO DE USO 10 \n");
		System.out.printf("TEST TRAER TURNOS COMPLETADOS DEL CLIENTE: %s %s%n",
		    cliente.getNombre(), cliente.getApellido());

        // Mostrar los turnos
        for (Turno t : turnos) {
            System.out.println("Turno: " + t + " | Estado: " + t.getEstado());
        }
		
		

	}

}
