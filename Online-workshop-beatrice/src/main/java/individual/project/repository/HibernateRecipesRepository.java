package individual.project.repository;
import individual.project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateRecipesRepository {
    public List<Recipe> getRecipes() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try(
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!
            List<Recipe> result = session.createQuery("from Recipe", Recipe.class).list();


            session.getTransaction().commit();
           // session.close();
          //  sessionFactory.close();
            return result;
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw new Exception("Cannot read items from the database", e);
        }
    }
    public void create(Recipe i) throws Exception {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (
                // builds a session factory from the service registry
                SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                // obtains the session
                Session session = sessionFactory.openSession();

        ) {


            session.beginTransaction();

            // insert student to the database and get the auto-generated student_number
            Integer id = (Integer) session.save(i);
            i.setId(id); // set the auto-generated student_number

            session.getTransaction().commit();
          //  session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Cannot create Recipe " + i, e);
        }

    }
}
