package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Servicio;
import util.HibernateUtil;

public class ServicioDao {
    private Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en ServicioDao", he);
    }

    public int agregar(Servicio servicio) {
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(servicio);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Servicio servicio) {
        try {
            iniciaOperacion();
            session.update(servicio);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Servicio servicio) {
        try {
            iniciaOperacion();
            session.delete(servicio);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Servicio traer(int idServicio) {
        Servicio servicio = null;
        try {
            iniciaOperacion();
            servicio = session.get(Servicio.class, idServicio);
        } finally {
            session.close();
        }
        return servicio;
    }

    public List<Servicio> traerTodos() {
        List<Servicio> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Servicio s order by s.nombre", Servicio.class).getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}
