package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Empleado;
import util.HibernateUtil;

public class EmpleadoDao {
	private Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en EmpleadoDao", he);
	}

	public int agregar(Empleado empleado) {
		int id = 0;
		try {
			iniciaOperacion();
			id = (int) session.save(empleado);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Empleado empleado) {
		try {
			iniciaOperacion();
			session.update(empleado);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Empleado empleado) {
		try {
			iniciaOperacion();
			session.delete(empleado);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Empleado traer(int idEmpleado) {
		Empleado empleado = null;
		try {
			iniciaOperacion();
			empleado = session.get(Empleado.class, idEmpleado);
		} finally {
			session.close();
		}
		return empleado;
	}

	public Empleado traerPorDni(long dni) {
		Empleado empleado = null;
		try {
			iniciaOperacion();
			empleado = session.createQuery("from Empleado e where e.dni = :dni", Empleado.class)
					.setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return empleado;
	}
  
	public List<Empleado> traerTodos() {
		List<Empleado> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Empleado e order by e.apellido, e.nombre", Empleado.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
