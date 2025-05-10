package negocio;

import java.time.LocalDate;
import java.util.Set;

import dao.ClienteDao;
import datos.Cliente;
import datos.Turno;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
}
	
	
	public int agregar(Cliente c) throws Exception {
	    if (traer(c.getDni()) != null) {
	        throw new Exception("Ya existe un cliente con DNI " + c.getDni());
	    }
	    return dao.agregar(c);
	}

}