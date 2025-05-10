package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Turno;


public class TurnoDao {
    private Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en TurnoDao", he);
    }

    public int agregar(Turno turno) {
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Turno turno) {
        try {
            iniciaOperacion();
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Turno turno) {
        try {
            iniciaOperacion();
            session.delete(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Turno traer(int idTurno) {
        Turno turno = null;
        try {
            iniciaOperacion();
            turno = session.get(Turno.class, idTurno);
        } finally {
            session.close();
        }
        return turno;
    }
    
    
    public List<Turno> traerTodos() {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno t order by t.fecha, t.horaTurno", Turno.class).getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
    
    public List<Turno> traerPorEmpleado(int dniEmpleado) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery(
                        "from Turno t where t.empleado.dni = :dni order by t.fecha", 
                        Turno.class)
                    .setParameter("dni", dniEmpleado)
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

}
