package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Customer;
import be.intecbrussel.repository.RepositoryCustomer;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServiceCustomer {
    private RepositoryCustomer repositoryCustomerMenu = new RepositoryCustomer();

    public void createCustomer(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryCustomerMenu.createCustomer(entityManager, customer);
        entityManager.close();
    }

    public Optional<Customer> findUser(long id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Customer> customer = repositoryCustomerMenu.findCustomer(entityManager, id);
        entityManager.close();
        return customer;
    }

    public void updateCustomer(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        long customerId = customer.getCustomerNumber();
        Optional<Customer> optionalCustomer = repositoryCustomerMenu.findCustomer(entityManager, customerId);
        if (optionalCustomer.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deleteCustomer(long id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Customer> customer = repositoryCustomerMenu.findCustomer(entityManager,id);
        if(customer.isPresent()) {
            repositoryCustomerMenu.deleteCustomer(entityManager,customer.get());
        }
        else {
            System.out.println("not found");
        }
        entityManager.close();
    }

}
