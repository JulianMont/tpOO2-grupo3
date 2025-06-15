package negocio;

import dao.EmpleadoDao;
import datos.Empleado;

public class EmpleadoABM {
	
	private EmpleadoDao dao;
	
	public EmpleadoABM() {
		this.dao = new EmpleadoDao();
	}

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
	
	public boolean eliminar(int id) throws Exception {
		
		Empleado empleado = dao.traer(id);
		if(empleado == null) {
			throw new Exception("No existe este empleado");
		}
		
		dao.eliminar(empleado);
		return true;
	}
	
	public Empleado modificar(int id,Empleado e) throws Exception{
		
		Empleado empleado = dao.traer(id);
		
		if(empleado == null) {
			throw new Exception("No existe este empleado");
		}
		
		empleado.setNombre(e.getNombre());
		empleado.setApellido(e.getApellido());
		empleado.setDni(e.getDni());
		empleado.setEmail(e.getEmail());
		empleado.setMovil(e.getMovil());
		empleado.setTelefono(e.getTelefono());
		empleado.setLegajo(e.getLegajo());
		empleado.setPuesto(e.getPuesto());
		empleado.setTurnos(e.getTurnos());
		empleado.setEstado(e.isEstado());
		
		dao.actualizar(empleado);
		
		return empleado;
	}


}