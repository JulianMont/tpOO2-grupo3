package dao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
//				System.setProperty("DB_URL", System.getenv("DB_URL"));
//                System.setProperty("DB_USERNAME", System.getenv("DB_USERNAME"));
//                System.setProperty("DB_PASSWORD", System.getenv("DB_PASSWORD"));
				StandardServiceRegistry standardRegistry = new
				StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData = new	MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
		} catch (HibernateException he) {
			System.err.println("ERROR en la inicialización de la SessionFactory:" + he);
					throw new ExceptionInInitializerError(he);
		}
		
	return sessionFactory;
	
	}
}

