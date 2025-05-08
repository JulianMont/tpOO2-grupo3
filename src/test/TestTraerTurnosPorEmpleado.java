package test;

import dao.EmpleadoDao;
import dao.ClienteDao;
import dao.ServicioDao;
import dao.TurnoDao;
import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;
import datos.EstadoTurno;

import java.util.HashSet;
import java.util.List;

public class TestTraerTurnosPorEmpleado {
    public static void main(String[] args) {
        // Instanciamos los DAOs
        EmpleadoDao empleadoDao = new EmpleadoDao();
        ClienteDao clienteDao = new ClienteDao();
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

        // Crear y guardar Turno
        Turno turno = new Turno();
        turno.setEstado(EstadoTurno.EN_PROCESO);
        turno.setFecha(null); // Puede ser null dependiendo de la configuración de la base de datos
        turno.setHoraTurno(null); // idem
        turno.setCliente(cliente);
        turno.setEmpleado(empleado);
        turno.setServicio(servicio);
        turnoDao.agregar(turno);

        // Obtener los turnos por empleado
        List<Turno> turnos = empleadoDao.obtenerTurnosPorEmpleado(empleado.getIdPersona());

        // Verificar los resultados
        System.out.println("Turnos del empleado " + empleado.getNombre() + ":");
        for (Turno t : turnos) {
            System.out.println("- ID Turno: " + t.getIdTurno() + " | Estado: " + t.getEstado());
        }
    }
}
