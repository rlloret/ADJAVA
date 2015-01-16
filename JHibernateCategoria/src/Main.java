
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {


    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Categoria categoria=new Categoria(101, "Hibernate");
        
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(categoria);
        session.getTransaction().commit();
        
        
        Categoria categoria2=(Categoria)session.get(Categoria.class,101);
        System.out.println(categoria2.getId());
        System.out.println(categoria2.getNombre());
    
        
        categoria2.setNombre("Hibernate2222");
        
        session.beginTransaction();
        session.update(categoria2);
        session.getTransaction().commit();        

        session.beginTransaction();
        session.delete(categoria2);
        session.getTransaction().commit(); 
        
        
        session.close();
        sessionFactory.close();
    }
}