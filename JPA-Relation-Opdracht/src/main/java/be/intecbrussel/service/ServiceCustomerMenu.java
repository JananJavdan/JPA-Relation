package be.intecbrussel.service;

import be.intecbrussel.repository.RepositoryCustomerMenu;

import javax.persistence.EntityManager;

public class ServiceCustomerMenu {

    private RepositoryCustomerMenu repositoryCustomerMenu;
    private EntityManager entityManager;

    public ServiceCustomerMenu(RepositoryCustomerMenu repositoryCustomerMenu, EntityManager entityManager) {
        this.repositoryCustomerMenu = repositoryCustomerMenu;
    }
    public void createCustomerMenu() {
        entityManager.getTransaction().begin();
        entityManager.persist(repositoryCustomerMenu);
        entityManager.getTransaction().commit();
    }
    public void UpdateCustomerMenu() {
        entityManager.getTransaction().begin();
        entityManager.merge(repositoryCustomerMenu);
        entityManager.getTransaction().commit();
    }
    public void DeleteCustomerMenu() {
        entityManager.getTransaction().begin();
        entityManager.remove(repositoryCustomerMenu);
        entityManager.getTransaction().commit();
    }

}
