package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Turno;

import negocio.TurnoABM;

public class TestTraerTurnosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TurnoABM abm = new TurnoABM();
		
		Cliente cliente = new Cliente();
		cliente.setIdPersona(1);
		
		LocalDate fecha = LocalDate.of(2025, 5, 8);
		
		List<Turno> listaTurnos = abm.traerTurnosCliente(cliente, fecha);
		
		for(Turno turno : listaTurnos) {
			System.out.println(turno);
		}
		
		System.out.println("OK");
	}

}
