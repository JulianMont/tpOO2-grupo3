package negocio;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioABM {
	ServicioDao dao= new ServicioDao();
	
	
	public Servicio traer( String nombre) {
		Servicio s = dao.traer(nombre);
		return s;
	}
	
	public int agregar(Servicio s) throws Exception {
		if (traer(s.getNombre())!=null) {
			throw new Exception("Este servicio ya existe");}
		
	return dao.agregar(s);
			
	}
	
	public Servicio traerPorId( int id) {
		Servicio s = dao.traerPorId(id);
		return s;
	}

	public int getIdServicio() {
		// TODO Auto-generated method stub
		return 0;
	}
} 
