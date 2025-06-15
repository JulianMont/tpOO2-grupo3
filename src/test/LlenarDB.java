package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Empleado;
import datos.EstadoTurno;
import datos.Servicio;
import datos.Turno;
import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class LlenarDB {

	public static void main(String[] args) {
		try {
		    // Crear instancia de ABM
		    ClienteABM clienteABM = new ClienteABM();
		    EmpleadoABM empleadoABM = new EmpleadoABM();
		    ServicioABM servicioABM = new ServicioABM();
		    TurnoABM turnoABM = new TurnoABM();

		    Cliente cliente1 = new Cliente("Ana", "Martínez", 33123456, "ana.martinez@gmail.com", "1155667788", "44112233", null, true);
		    Cliente cliente2 = new Cliente("Luis", "González", 33123457, "luis.gonzalez@gmail.com", "1166778899", "44112234", null, true);
		    Cliente cliente3 = new Cliente("Carla", "López", 33223344, "carla.lopez@gmail.com", "1144556677", "44112235", null, true);
		    Cliente cliente4 = new Cliente("Diego", "Fernández", 33445566, "diego.fernandez@gmail.com", "1133224455", "44112236", null, true);
		    Cliente cliente5 = new Cliente("Julia", "Ramírez", 33556677, "julia.ramirez@gmail.com", "1199887766", "44112237", null, true);

		    Empleado empleado1 = new Empleado("Laura", "González", 30211222, "laura.gonzalez@empresa.com", "1122334455", "43781111", "E001", "Recepcionista", null, true);
		    Empleado empleado2 = new Empleado("Carlos", "Pérez", 30211223, "carlos.perez@empresa.com", "1188776655", "43781112", "E002", "Cajero", null, true);
		    Empleado empleado3 = new Empleado("Sofía", "Morales", 30211224, "sofia.morales@empresa.com", "1133557799", "43781113", "E003", "Estilista", null, true);
		    Empleado empleado4 = new Empleado("Federico", "Díaz", 30211225, "federico.diaz@empresa.com", "1177889900", "43781114", "E004", "Asistente", null, true);
		    Empleado empleado5 = new Empleado("Paula", "Suárez", 30211226, "paula.suarez@empresa.com", "1144226688", "43781115", "E005", "Administrador", null, true);

		    Servicio servicio1 = new Servicio("Corte de cabello", "Corte de cabello estándar para adultos");
		    Servicio servicio2 = new Servicio("Manicure", "Cuidado y esmaltado de uñas");
		    Servicio servicio3 = new Servicio("Pedicure", "Limpieza y cuidado de pies y uñas");
		    Servicio servicio4 = new Servicio("Coloración", "Tinte completo o parcial de cabello");
		    Servicio servicio5 = new Servicio("Peinado", "Peinados para eventos y uso diario");

		    Set<Servicio> servicios1 = new HashSet<>();
		    servicios1.add(servicio1); // Corte de cabello

		    Turno turno1 = new Turno();
		    turno1.setFecha(LocalDate.now());
		    turno1.setHoraTurno(LocalDateTime.now().plusHours(1));
		    turno1.setCliente(cliente1);
		    turno1.setEmpleado(empleado1);
		    turno1.setEstado(EstadoTurno.EN_PROCESO);
		    turno1.setServicios(servicios1);

		    Set<Servicio> servicios2 = new HashSet<>();
		    servicios2.add(servicio2); // Manicure

		    Turno turno2 = new Turno();
		    turno2.setFecha(LocalDate.now());
		    turno2.setHoraTurno(LocalDateTime.now().plusHours(2));
		    turno2.setCliente(cliente2);
		    turno2.setEmpleado(empleado5);
		    turno2.setEstado(EstadoTurno.EN_PROCESO);
		    turno2.setServicios(servicios2);

		    Set<Servicio> servicios3 = new HashSet<>();
		    servicios3.add(servicio4); //

		    Turno turno3 = new Turno();
		    turno3.setFecha(LocalDate.now().plusDays(1));
		    turno3.setHoraTurno(LocalDateTime.now().plusDays(1).withHour(10));
		    turno3.setCliente(cliente3);
		    turno3.setEmpleado(empleado4);
		    turno3.setEstado(EstadoTurno.EN_PROCESO);
		    turno3.setServicios(servicios3);

		    Set<Servicio> servicios4 = new HashSet<>();
		    servicios4.add(servicio3); // Pedicure

		    Turno turno4 = new Turno();
		    turno4.setFecha(LocalDate.now().plusDays(2));
		    turno4.setHoraTurno(LocalDateTime.now().plusDays(2).withHour(11));
		    turno4.setCliente(cliente4);
		    turno4.setEmpleado(empleado3);
		    turno4.setEstado(EstadoTurno.EN_PROCESO);
		    turno4.setServicios(servicios4);

		    Set<Servicio> servicios5 = new HashSet<>();
		    servicios5.add(servicio1);
		    servicios5.add(servicio5); // Corte de cabello + Depilación

		    Turno turno5 = new Turno();
		    turno5.setFecha(LocalDate.now().plusDays(3));
		    turno5.setHoraTurno(LocalDateTime.now().plusDays(3).withHour(9));
		    turno5.setCliente(cliente5);
		    turno5.setEmpleado(empleado2);
		    turno5.setEstado(EstadoTurno.EN_PROCESO);
		    turno5.setServicios(servicios5);
		    
		    Turno turno6 = new Turno();
		    turno6.setFecha(LocalDate.now().plusDays(2));
		    turno6.setHoraTurno(LocalDateTime.now().plusDays(2).withHour(11));
		    turno6.setCliente(cliente5);
		    turno6.setEmpleado(empleado3);
		    turno6.setEstado(EstadoTurno.EN_PROCESO);
		    turno6.setServicios(servicios4);

		    
		 // Para Cliente
		   clienteABM.agregar(cliente1);
		   clienteABM.agregar(cliente2);
		   clienteABM.agregar(cliente3);
		   clienteABM.agregar(cliente4);
		   clienteABM.agregar(cliente5);

		    // Para Empleado
		    empleadoABM.agregar(empleado1);
		    empleadoABM.agregar(empleado2);
		    empleadoABM.agregar(empleado3);
		    empleadoABM.agregar(empleado4);
		    empleadoABM.agregar(empleado5);

		    // Para Servicio
		    servicioABM.agregar(servicio1);
		    servicioABM.agregar(servicio2);
		    servicioABM.agregar(servicio3);
		    servicioABM.agregar(servicio4);
		    servicioABM.agregar(servicio5);

		    // Para Turno
		 turnoABM.agregar(turno1);
		 turnoABM.agregar(turno2);
		 turnoABM.agregar(turno3);
		 turnoABM.agregar(turno4);
		 turnoABM.agregar(turno5);
		 turnoABM.agregar(turno6);

		    
		    System.out.println("DB cargada");


		} catch (Exception e) {
		    e.printStackTrace();
		}


	}

}
