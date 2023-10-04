package com.aminenurgynk.repository;

import com.aminenurgynk.model.Car;
import com.aminenurgynk.untility.HibernateUtility;
import com.aminenurgynk.untility.ICrud;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class CarRepository implements ICrud<Car> {

    Session session;
    Transaction transaction;

    @Override
    public Car save(Car car) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return car;
    }

    @Override
    public Car update(Car car) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return car;
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
    public List<Car> findAll() {

        String hql = " SELECT c FROM Car AS c";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Car> typedQuery = session.createQuery(hql, Car.class);
        List<Car> carList = typedQuery.getResultList();
        return carList;
    }

    @Override
    public Car findById(Long id) {
        session = HibernateUtility.getSessionFactory().openSession();
        Car car = session.find(Car.class,id);
        if (car == null){
            System.out.println("The car could not be found");
        }
        return car;
    }

    public  List<Car> carsRent(){
        try{
            session = HibernateUtility.getSessionFactory().openSession();
            return session.createQuery("FROM Car WHERE status = 'RENTED'", Car.class).list();

        }catch (Exception e){
            System.err.println("Error ---> " + e);
            return null;
        }
    }

    public List<Car> carsAvailable(){
        try{
            session = HibernateUtility.getSessionFactory().openSession();
            return session.createQuery("FROM Car WHERE status = 'AVAILABLE'", Car.class).list();

        }catch (Exception e){
            System.err.println("Error ---> " + e);
            return null;
        }
    }

    public List<Car> findRentedCarByCustomerId(long id){
        String hql = "SELECT r.car FROM Rent r WHERE r.customer.id =: id";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Car> typedQuery = session.createQuery(hql, Car.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList();
    }
}
