package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import negocio.TurnoABM;

public class TestModificarDiaYHoraTurno {

	public static void main(String[] args) {
        
        
        TurnoABM turnoABM = new TurnoABM();
        
        LocalDate fechaModificada = LocalDate.of (2025,7,12);
		LocalDateTime horaModificada = fechaModificada.atTime(17,50);

        

        turnoABM.modificarTurnoPorDiaYHora(1,fechaModificada,horaModificada);
                
        
	}

}