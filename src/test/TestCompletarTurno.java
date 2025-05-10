package test;

import datos.EstadoTurno;
import datos.Cliente;
import datos.Empleado;
import datos.Turno;
import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.ServicioABM;
import negocio.TurnoABM;
import datos.Servicio;
import dao.ClienteDao;
import dao.EmpleadoDao;
import dao.ServicioDao;
import dao.TurnoDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class TestCompletarTurno {
    public static void main(String[] args) {
    	TurnoABM turnoAbm = new TurnoABM();
    	ClienteABM clienteAbm = new ClienteABM();
        EmpleadoABM empleadoAbm = new EmpleadoABM();
        ServicioABM servicioAbm = new ServicioABM();
       	

        // Crear y guardar Cliente
        Cliente cliente = new Cliente(
                "Mati", "Forlan",123336 , "juan@email.com", "11111", "22222",
                new HashSet<>(), true
        );
        try {
			clienteAbm.agregar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // Crear y guardar Empleado
        Empleado empleado = new Empleado(
                "Roman", "Perez", 34567, "pedro@email.com", "45697833", "9",
                "LEG123", "Mecanico", new HashSet<>(), true
        );
        try {
			empleadoAbm.agregar(empleado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(empleado.getDni());
        // Crear y guardar Servicio
        Servicio servicio = new Servicio("Farmacia", "Se venden medicamentos");
        try {
			servicioAbm.agregar(servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        // Crear Turno con entidades ya persistidas
        Turno turno = new Turno();
        turno.setEstado(EstadoTurno.EN_PROCESO.name());
        turno.setFecha(null);  // Temporal si la columna permite null
        turno.setHoraTurno(null);
        turno.setCliente(cliente);
        turno.setEmpleado(empleado);
        turno.setServicio(servicio);
        try {
			turnoAbm.agregar(turno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(turno.getIdTurno());
        
        try {
            turnoAbm.completarTurno(turno.getIdTurno(), true);

            Turno t1 = turnoAbm.traer(turno.getIdTurno());
            System.out.println("Esperado: COMPLETADO | Real: " + t1.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}



