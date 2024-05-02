package be.intecbrussel.repository;

import be.intecbrussel.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RepositoryCustomerMenu {

    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public Customer create(Customer customer) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }
    public Customer read(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return customer;
    }
    public void update(Customer customer) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }
}
