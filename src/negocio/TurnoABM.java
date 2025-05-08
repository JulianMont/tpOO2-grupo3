package negocio;

import dao.TurnoDao;

public class TurnoABM {
	private TurnoDao turnoDao = new TurnoDao();

	public List<Turno> getTurnosDeEmpleado(int idEmpleado) {
	 return turnoDao.obtenerTurnosPorEmpleado(idEmpleado);
	    }
	}

}
