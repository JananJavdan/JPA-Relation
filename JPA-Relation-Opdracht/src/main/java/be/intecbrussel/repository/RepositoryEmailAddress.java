package be.intecbrussel.repository;

import be.intecbrussel.model.EmailAddress;
import be.intecbrussel.model.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryEmailAddress {
    public void createEmailAddress(EntityManager entityManager, EmailAddress emailAddress) {
        entityManager.getTransaction().begin();
        entityManager.persist(emailAddress);
        entityManager.getTransaction().commit();
    }

    public Optional<EmailAddress> findEmail(EntityManager entityManager, Long id) {
        EmailAddress optionalEmailAddress = entityManager.find(EmailAddress.class, id);
        return Optional.ofNullable(optionalEmailAddress);
    }

    public void updateEmailAddress(EntityManager entityManager, EmailAddress emailAddress) {
        entityManager.getTransaction().begin();
        entityManager.merge(emailAddress);
        entityManager.getTransaction().commit();
    }

    public void deleteEmailAddress(EntityManager entityManager, EmailAddress emailAddress) {
        entityManager.getTransaction().begin();
        entityManager.remove(emailAddress);
        System.out.println("deleted");
        entityManager.getTransaction().commit();
    }

}
