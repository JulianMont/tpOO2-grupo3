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
    	
       
        
        
        
        try {
        	
        	Turno t1 = turnoAbm.traer(2);
        	System.out.println("---CASO DE USO 6:CAMBIAR ESTADO DEL TURNO A COMPLETADO-- ");
        	System.out.println("Estado actual  " + t1.getEstado());
            turnoAbm.completarTurno(t1.getIdTurno(), false);

            Turno t1Actualizado = turnoAbm.traer(t1.getIdTurno());
            System.out.println("Esperado: COMPLETADO | Real: " + t1Actualizado.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}

