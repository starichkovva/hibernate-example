package org.starichkov.java.orm.hibernate;

import com.google.common.collect.Lists;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Vadim Starichkov
 * @since 29.12.2016 15:00
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Customer jediCustomer = new Customer("Obi-Wan Kenobi");
            jediCustomer.setOrders(
                    Lists.newArrayList(
                            new Order("Blue Lightsaber"),
                            new Order("Jedi Interceptor")
                    )
            );
            session.save(jediCustomer);

            Customer sithCustomer = new Customer("Darth Vader");
            sithCustomer.setOrders(
                    Lists.newArrayList(
                            new Order("Red Lightsaber"),
                            new Order("Death Star"),
                            new Order("Star Destroyer"),
                            new Order("Army of Stormtroopers")
                    )
            );
            session.save(sithCustomer);

            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Customer> result = session.createQuery("from Customer", Customer.class).list();
            result.forEach(System.out::println);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e);
        }
    }
}
