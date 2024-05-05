package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.RepositoryUser;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServiceUser {
    private RepositoryUser repositoryUserEmailAdress = new RepositoryUser();

    public void createUser(User user) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryUserEmailAdress.createUser(entityManager, user);
        entityManager.close();
    }

    public Optional<User> findUser(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<User> user = repositoryUserEmailAdress.findUser(entityManager, id);
        entityManager.close();
        return user;
    }

    public void updateUser(User user) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        int userId = user.getId();
        Optional<User> optionalUser = repositoryUserEmailAdress.findUser(entityManager, userId);
        if (optionalUser.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deleteUser(int id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<User> user = repositoryUserEmailAdress.findUser(entityManager,id);
        if(user.isPresent()) {
            repositoryUserEmailAdress.deleteUser(entityManager,user.get());
        }
        else {
            System.out.println("Record not found");
        }
        entityManager.close();
    }
}





