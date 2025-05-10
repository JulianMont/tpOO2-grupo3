package negocio;

import java.util.Set;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.Turno;

public class EmpleadoABM {
	EmpleadoDao dao =new EmpleadoDao();
	
	
	public Empleado traer(int dni) {
		Empleado e = dao.traerPorDni(dni);
		return e;
	}
	
	public int agregar(Empleado e) throws Exception {
	    if (traer(e.getDni()) != null) {
	        throw new Exception("Ya existe este empleado");
	    }
	    return dao.agregar(e);
	}


}
