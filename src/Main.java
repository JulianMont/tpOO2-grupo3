import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Crear la configuración de Hibernate
        Configuration config = new Configuration().configure("hibernate.cfg.xml");

        // Crear una fábrica de sesiones
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Abrir una sesión
        Session session = sessionFactory.openSession();

        // Iniciar una transacción
        session.beginTransaction();
        
        System.out.println("¡Hibernate está funcionando!");

        // Cerrar la sesión
        session.getTransaction().commit();
        session.close();
    }
}
