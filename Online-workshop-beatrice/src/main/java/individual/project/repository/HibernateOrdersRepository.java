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

public class HibernateOrdersRepository {


    public List<Order> getOrders() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!
            List<Order> result = session.createQuery("from Order ", Order.class).list();


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

    public List<Order> getAllOrderOfOneUser(int userId) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String jpql = "from Order where userId = :userId";
            List<Order> result =
                    session.createQuery(jpql, Order.class).setParameter("userId", userId).list();

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

    public List<OrderItem> getOrderItems(int nr) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String jpql = "from OrderItem where order_orderNumber = :nr";
            List<OrderItem> result =
                    session.createQuery(jpql, OrderItem.class).setParameter("nr", nr).list();



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
    public Order getOrderById(int orderNumber) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!
            Order o = (Order)session.get(Order.class, orderNumber);


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
    public User getUserfromOrder(int orderNumber) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            // "from Student" should be on the class name "Student", not table name "students"!

            User user = (User)session.get(User.class, orderNumber);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return user;
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw new Exception("Cannot read items from the database", e);
        }
    }

    public void create(Order o) throws Exception {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {

            // builds a session factory from the service registry
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            // obtains the session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // insert student to the database and get the auto-generated student_number
            Integer id = (Integer) session.save(o);
            o.setOrderNumber(id); // set the auto-generated student_number

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Cannot create order " + o, e);
        }

    }

    public void update(Order o) throws Exception {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {

            // builds a session factory from the service registry
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            // obtains the session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

           session.update(o);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new Exception("Cannot update order " + o, e);
        }

    }
    public void delete() throws Exception {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {

            // builds a session factory from the service registry
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            // obtains the session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.createQuery("delete from Order").executeUpdate(); // fixed in runtime


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
