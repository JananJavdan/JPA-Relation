package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.EmailAddress;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.RepositoryEmailAddress;
import be.intecbrussel.repository.RepositoryUser;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServiceEmailAddress {
    private RepositoryEmailAddress repositoryEmailAdress = new RepositoryEmailAddress();

    public void createEmailAddress(EmailAddress emailAddress) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryEmailAdress.createEmailAddress(entityManager, emailAddress);
        entityManager.close();
    }

    public Optional<EmailAddress> findEmailAddress(Long id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<EmailAddress> emailAddress = repositoryEmailAdress.findEmail(entityManager, id);
        entityManager.close();
        return emailAddress;
    }

    public void updateEmailAddress(EmailAddress emailAddress) {
        if (emailAddress == null || emailAddress.getUser() == null) {
            System.out.println("Error: EmailAddress or User is null.");
            return;
        }

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        String emailAddressUser = String.valueOf(emailAddress.getUser().getId());
        Optional<EmailAddress> optionalEmailAddress = repositoryEmailAdress.findEmail(entityManager, emailAddress.getId());
        if (optionalEmailAddress.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deleteEmailAddress(long id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<EmailAddress> emailAddress = repositoryEmailAdress.findEmail(entityManager, id);
        if(emailAddress.isPresent()) {
            repositoryEmailAdress.deleteEmailAddress(entityManager,emailAddress.get());
        }
        else {
            System.out.println("Record not found");
        }
        entityManager.close();
    }
}
