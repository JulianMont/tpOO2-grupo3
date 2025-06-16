package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.ServicioABM;
import negocio.TurnoABM;
import datos.Turno;

    public class TestGenerarTurno {
        public static void main(String[] args) {
        ClienteABM clienteABM = new ClienteABM();
        EmpleadoABM empleadoABM = new EmpleadoABM();
        ServicioABM servicioABM = new ServicioABM();
        TurnoABM turnoabm = new TurnoABM();
        
        LocalDate fecha = LocalDate.of(2025, 9, 25);
        LocalDateTime dia = LocalDateTime.of(2025, 9, 25, 14, 30);

        Cliente cliente = clienteABM.traer(33123456);
        Empleado empleado = empleadoABM.traer(30211225);
        Servicio servicio = servicioABM.traerPorId(1);

        Set<Servicio> servicios = new HashSet<>();
        servicios.add(servicio);

        try {
            Turno turno = turnoabm.reservarTurno(fecha, dia, cliente, empleado, servicios);
            System.out.println("CASO DE USO 1/ SOLICITAR NUEVO TURNO");
            System.out.println(turno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


}