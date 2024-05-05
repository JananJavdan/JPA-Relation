package be.intecbrussel.repository;

import be.intecbrussel.model.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryUser {
    public void createUser(EntityManager entityManager, User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public Optional<User> findUser(EntityManager entityManager, int id) {
        User optionalUser = entityManager.find(User.class, id);
        return Optional.ofNullable(optionalUser);
    }

    public void updateUser(EntityManager entityManager, User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void deleteUser(EntityManager entityManager, User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        System.out.println("deleted");
        entityManager.getTransaction().commit();
    }
}



