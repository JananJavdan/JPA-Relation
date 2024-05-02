package be.intecbrussel.service;

import be.intecbrussel.model.User;
import be.intecbrussel.repository.RepositoryUserEmailAdress;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class ServiceUserEmailAdress {

    private RepositoryUserEmailAdress repositoryUserEmailAdress;
    private EntityManager entityManager;

    public ServiceUserEmailAdress(RepositoryUserEmailAdress repositoryUserEmailAdress, EntityManager entityManager) {
        this.repositoryUserEmailAdress = repositoryUserEmailAdress;
    }
    public void createUserEmailAdress(User user) {

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    public void updateUserEmailAdress(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }
    public void deleteUserEmailAdress(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

}
