package test;

import datos.EstadoTurno;
import datos.Cliente;
import datos.Empleado;
import datos.Turno;
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
    
    	ClienteDao clienteDao = new ClienteDao();
        EmpleadoDao empleadoDao = new EmpleadoDao();
        ServicioDao servicioDao = new ServicioDao();
        TurnoDao turnoDao = new TurnoDao();

        // Crear y guardar Cliente
        Cliente cliente = new Cliente(
                "Juan", "Pérez", 12345678, "juan@email.com", "111-1111", "222-2222",
                new HashSet<>(), true
        );
        clienteDao.agregar(cliente);

        // Crear y guardar Empleado
        Empleado empleado = new Empleado(
                "Pedro", "Gómez", 87654321, "pedro@email.com", "333-3333", "444-4444",
                "LEG123", "Peluquero", new HashSet<>(), true
        );
        empleadoDao.agregar(empleado);

        // Crear y guardar Servicio
        Servicio servicio = new Servicio("Corte de cabello", "Corte de cabello para hombre");
        servicioDao.agregar(servicio);

        // Crear Turno con entidades ya persistidas
        Turno turno = new Turno();
        turno.setEstado(EstadoTurno.EN_PROCESO);
        turno.setFecha(null);  // Temporal si la columna permite null
        turno.setHoraTurno(null);
        turno.setCliente(cliente);
        turno.setEmpleado(empleado);
        turno.setServicio(servicio);
        turnoDao.agregar(turno);

        try {
            // Completar el turno
            turno.setEstado(EstadoTurno.COMPLETADO);
            turnoDao.actualizar(turno);

            Turno t1 = turnoDao.traer(turno.getIdTurno());
            System.out.println("Esperado: COMPLETADO | Real: " + t1.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


