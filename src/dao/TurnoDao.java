package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.EstadoTurno;
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
    public List<Turno> traerTurnosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws HibernateException{
    	
    	List<Turno> turnos = null;
    	
    	try {
    		iniciaOperacion();
    		
    		String hql = "from Turno t where t.fecha between :fechaInicio AND :fechaFin";
    		Query<Turno> query = session.createQuery(hql,Turno.class)
    				.setParameter("fechaInicio", fechaInicio)
    				.setParameter("fechaFin", fechaFin);
    		
            turnos = query.getResultList();
            
            for (Turno turno : turnos) {
                Hibernate.initialize(turno.getCliente());
                Hibernate.initialize(turno.getEmpleado());
                Hibernate.initialize(turno.getServicios());
            }
            
            
        
          
		} finally {
			session.close();
			// TODO: handle finally clause
		}
    	
		return turnos;
	 }
    
    
    //CU 8
    
    public List<Turno> traerTurnosCliente(int idCliente,LocalDate fecha){
    	
    	List<Turno> turnos = null;
    	
    	try {
    		iniciaOperacion();
    		
    		String hql = "from Turno t where t.cliente.id = :idCliente and t.fecha = :fecha";
    		Query<Turno> query = session.createQuery(hql, Turno.class)
    				.setParameter("idCliente", idCliente)
    				.setParameter("fecha", fecha);
    		turnos = query.getResultList();
    		
            for (Turno turno : turnos) {
                Hibernate.initialize(turno.getCliente());
                Hibernate.initialize(turno.getEmpleado());
                Hibernate.initialize(turno.getServicios());
            }
            
    		
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

    
    // CdU 9
    
    public List<Turno> traerTurnosPorEmpleadoFechaHora(int dniEmpleado, LocalDate fecha, LocalDateTime horaTurno) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery(
                "from Turno t where t.empleado.dni = :dni and t.fecha = :fecha and t.horaTurno = :horaTurno order by t.fecha", 
                Turno.class)
                .setParameter("dni", dniEmpleado)
                .setParameter("fecha", fecha)
                .setParameter("horaTurno", horaTurno)
                .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }


    public List<Turno> traerPorServicioYFecha(int idServicio, LocalDate fecha) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery(
                "select t from Turno t join t.servicios s " +
                "where s.idServicio = :idServicio and t.fecha = :fecha", Turno.class)
                .setParameter("idServicio", idServicio)
                .setParameter("fecha", fecha)
                .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Turno> traerPorServicio(int id) {
        List<Turno> turnos = null;
        try {
            iniciaOperacion();
            String hql = "from Turno t where t.servicio = :servicio";
            turnos = session.createQuery(hql, Turno.class)
                            .setParameter("servicio", id)
                            .getResultList();
        } finally {
            session.close();
        }
        return turnos;
    }
    
    // --- CU 9 ---
    
    public List<Turno> traerCancelados() {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery(
                "from Turno t " +
                "join fetch t.cliente " +
                "join fetch t.servicios " +
                "where t.estado = :estadoCancelado " +
                "order by t.fecha, t.horaTurno", Turno.class)
                .setParameter("estadoCancelado", EstadoTurno.CANCELADO)
                .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
    
    
    //CU 11
    
    public List<Turno> traerTurnosEmpleado(int idEmpleado,LocalDate fecha){
    	
    	List<Turno> turnos = null;
    	
    	try {
    		iniciaOperacion();
    		
    		String hql = "from Turno t where t.empleado.id = :idEmpleado and t.fecha = :fecha";
    		Query<Turno> query = session.createQuery(hql, Turno.class)
    				.setParameter("idEmpleado", idEmpleado)
    				.setParameter("fecha", fecha);
    		turnos = query.getResultList();
    		
            for (Turno turno : turnos) {
                Hibernate.initialize(turno.getCliente());
                Hibernate.initialize(turno.getEmpleado());
                Hibernate.initialize(turno.getServicios());
            }
            
    		
		} finally {
			session.close();
			// TODO: handle finally clause
		}
    	
    	
    	return turnos;
    }
    
}
