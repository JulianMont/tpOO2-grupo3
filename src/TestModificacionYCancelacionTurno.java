package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Empleado;
import datos.Turno;
import negocio.TurnoABM;

public class TestModificacionYCancelacionTurno {

	public static void main(String[] args) {
        

        Set<Turno> turnosCliente = new HashSet<>();

        Set<Turno> turnoEmpleado = new HashSet<>();

		Cliente cliente = new Cliente("Jose","Perez",12344321,"josepe@gmail.com","11 23452345","42415601",turnosCliente, true);
        
        Empleado empleado = new Empleado("Juan","Gomez",21212323,"Juango@outlook.com","11 26589566","35323631","L 1234",null, turnoEmpleado,true);

        LocalDate fecha = LocalDate.of (2025,5,11);
        LocalTime hora = LocalTime.of(10, 30);

        TurnoABM turno = new TurnoABM();

        LocalDate fechaModificada = LocalDate.of (2025,5,12);
		LocalDateTime horaModificada = LocalDateTime.of(fechaModificada,hora);

        

        turno.modificarTurno (1,fechaModificada,horaModificada);

       System.out.println(turno);

	   turno.cancelarTurno(1,cliente,false);
	   

		
		


	}
}