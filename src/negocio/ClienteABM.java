package negocio;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente(int dni) {
		Cliente c = dao.traerCliente(dni);
		// implementar si c es null lanzar Exception
		return c;
}
