package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
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
    
    
    //CU 7
    public List<Turno> traerTurnosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin){
    	
    	List<Turno> turnos = new ArrayList<Turno>();
    	
    	try {
    		iniciaOperacion();
    		
    		Query<Turno> query = session.createQuery("from Turno t where t.fecha between :fechaInicio AND :fechaFin", Turno.class)
    				.setParameter("fechaInicio", fechaInicio)
    				.setParameter("fechaFin", fechaFin);
    		turnos = query.getResultList();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
    	
		return turnos;
	 }
    
    
    //CU 8
    
    public List<Turno> traerTurnosCliente(Cliente cliente,LocalDate fecha){
    	
    	List<Turno> turnos = new ArrayList<Turno>();
    	
    	try {
    		iniciaOperacion();
    		
    		Query<Turno> query = session.createQuery("from Turno t where t.cliente = :cliente and t.fecha = :fecha", Turno.class)
    				.setParameter("cliente", cliente)
    				.setParameter("fecha", fecha);
    		turnos = query.getResultList();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
    	
    	
    	return turnos;
    }
    
    
    //CU6
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
