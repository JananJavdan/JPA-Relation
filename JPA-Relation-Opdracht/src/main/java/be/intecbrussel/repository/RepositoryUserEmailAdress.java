package be.intecbrussel.repository;

import be.intecbrussel.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class RepositoryUserEmailAdress {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public RepositoryUserEmailAdress() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Relation");
    }
    public User createUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }
    public User updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        return user;
    }
    public Optional<User> readUser(String email) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, email);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(user);
    }

}
