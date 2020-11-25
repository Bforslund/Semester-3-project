package individual.project.repository;

import individual.project.model.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateItemsRepository implements IItemRepository {


    @Override
    public List<Item> getItems() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try(
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!
            List<Item> result = session.createQuery("from Item ", Item.class).list();


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return result;
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw new Exception("Cannot read items from the database", e);
        }
    }
    @Override
    public void create(Item i) throws Exception {
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
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Cannot create item " + i, e);
        }

    }
    @Override
    public Item getItemById(int id) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try(
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!
            Item o = (Item)session.get(Item.class, id);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return o;
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw new Exception("Cannot read items from the database", e);
        }
    }
    @Override
    public void update(Item item) throws Exception {
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
            Item i = (Item)session.get(Item.class, item.getId());
            i.setName(item.getName());
            i.setIngredients(item.getIngredients());
            i.setBuyingPrice(item.getBuyingPrice());
            i.setSellingPrice(item.getSellingPrice());
            i.setType(item.getType());

            session.update(i);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Cannot create item " + item, e);
        }

    }
    @Override
    public void delete(int id) throws Exception {
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

            Item i = (Item)session.get(Item.class, id);
            session.delete(i);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Sorry cant delete");
        }

    }


}
