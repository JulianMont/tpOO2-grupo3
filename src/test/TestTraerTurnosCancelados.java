package test;


import java.util.List;

import datos.Turno;
import dao.TurnoDao;

public class TestTraerTurnosCancelados {
	
	public static void main(String[] args) {
        TurnoDao turnoDao = new TurnoDao();
        List<Turno> turnos = turnoDao.traerCancelados();

        System.out.println("=== Turnos Cancelados ===");
        for (Turno t : turnos) {
            System.out.println("ID: " + t.getIdTurno()
                + ", Cliente: " + t.getCliente().getNombre()
                + ", Servicios: " + t.getServicios()
                + ", Fecha: " + t.getFecha()
                + ", Hora: " + t.getHoraTurno());
        }

        if (turnos.isEmpty()) {
            System.out.println("No hay turnos cancelados.");
        }
    }
	
}
