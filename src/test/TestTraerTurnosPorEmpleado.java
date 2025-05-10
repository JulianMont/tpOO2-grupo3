package test;

import java.util.List;

import datos.Empleado;
import datos.Turno;
import negocio.EmpleadoABM;
import negocio.TurnoABM;

public class TestTraerTurnosPorEmpleado {
    public static void main(String[] args) {
        TurnoABM turnoABM = new TurnoABM();
        EmpleadoABM empleadoABM = new EmpleadoABM();

        // Traer empleado desde la base de datos por DNI
        Empleado empleado = empleadoABM.traer(1234); 

        // Traer los turnos del empleado
        List<Turno> turnos = turnoABM.traerTurnosDeEmpleado(empleado.getDni());

        // Mostrar los turnos
        for (Turno t : turnos) {
            System.out.println("Turno ID: " + t.getIdTurno() + " | Estado: " + t.getEstado());
        }
    }
}

