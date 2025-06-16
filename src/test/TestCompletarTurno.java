package test;


import datos.Turno;

import negocio.TurnoABM;


public class TestCompletarTurno {
    public static void main(String[] args) {
    	TurnoABM turnoAbm = new TurnoABM();
    	
       
        
        

        try {
        	
        	Turno t1 = turnoAbm.traer(5);
        	System.out.println("---CASO DE USO 6:CAMBIAR ESTADO DEL TURNO A COMPLETADO-- ");
        	System.out.println("Estado actual  " + t1.getEstado());
            turnoAbm.completarTurno(t1.getIdTurno(), true);

            Turno t1Actualizado = turnoAbm.traer(t1.getIdTurno());
            System.out.println("Esperado: COMPLETADO | Real: " + t1Actualizado.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}

