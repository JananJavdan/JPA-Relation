package be.intecbrussel.repository;

import be.intecbrussel.model.Customer;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryCustomer {
    public void createCustomer(EntityManager entityManager, Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }
    public Optional<Customer> findCustomer(EntityManager entityManager, long id) {
        Customer optionalUser = entityManager.find(Customer.class, id);
        return Optional.ofNullable(optionalUser);
    }

    public void updateCustomer(EntityManager entityManager, Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    public void deleteCustomer(EntityManager entityManager, Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        System.out.println("deleted");
        entityManager.getTransaction().commit();
    }

}
