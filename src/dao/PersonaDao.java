package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Persona;


public class PersonaDao {
    private Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en PersonaDao", he);
    }

    public int agregar(Persona persona) {
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(persona);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Persona persona) {
        try {
            iniciaOperacion();
            session.update(persona);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Persona persona) {
        try {
            iniciaOperacion();
            session.delete(persona);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Persona traer(int idPersona) {
        Persona persona = null;
        try {
            iniciaOperacion();
            persona = session.get(Persona.class, idPersona);
        } finally {
            session.close();
        }
        return persona;
    }

    public List<Persona> traerTodos() {
        List<Persona> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Persona p order by p.apellido, p.nombre", Persona.class).getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}
