package com.aminenurgynk.repository;

import com.aminenurgynk.model.Car;
import com.aminenurgynk.model.Customer;
import com.aminenurgynk.untility.HibernateUtility;
import com.aminenurgynk.untility.ICrud;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements ICrud<Customer> {

    Session session;
    Transaction transaction;

    @Override
    public Customer save(Customer customer) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Car car = session.get(Car.class, id);
            if (car != null) {
                session.delete(id);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {

        String hql = " SELECT c FROM Customer AS c";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Customer> typedQuery = session.createQuery(hql, Customer.class);
        List<Customer> customerList = typedQuery.getResultList();
        return customerList;
    }

    @Override
    public Customer findById(Long id) {

        session = HibernateUtility.getSessionFactory().openSession();
        Customer customer = session.find(Customer.class,id);
        if (customer == null){
            System.out.println("The customer could not be found");
        }
        return customer;
    }
}

