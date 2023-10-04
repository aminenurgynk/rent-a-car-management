package com.aminenurgynk.repository;

import com.aminenurgynk.model.Rent;
import com.aminenurgynk.untility.HibernateUtility;
import com.aminenurgynk.untility.ICrud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class RentRepository implements ICrud<Rent> {

    Session session;
    Transaction transaction;

    @Override
    public Rent save(Rent rent) {
        try{
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(rent);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return rent;
    }

    @Override
    public Rent update(Rent rent) {
        try{
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(rent);
            transaction.commit();
            System.out.println("That's it.");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return rent;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Rent rent = session.get(Rent.class, id);
            if (rent != null) {
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
    public List<Rent> findAll() {
        String hql = " SELECT e FROM Rent  AS e";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Rent> typedQuery = session.createQuery(hql, Rent.class);
        List<Rent> rentList = typedQuery.getResultList();
        return rentList;
    }

    @Override
    public Rent findById(Long id) {
        session = HibernateUtility.getSessionFactory().openSession();
        Rent rent = session.find(Rent.class,id);
        if (rent == null){
            System.out.println("The rent could not be found");
        }
        return rent;
    }
}
