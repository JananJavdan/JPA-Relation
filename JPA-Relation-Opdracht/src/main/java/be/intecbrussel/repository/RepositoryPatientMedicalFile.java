package be.intecbrussel.repository;

import be.intecbrussel.model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class RepositoryPatientMedicalFile {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public RepositoryPatientMedicalFile(Patient patient) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Relation");
    }
    public Patient createPatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
        return patient;
    }
    public Patient UpdatePatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
        return patient;
    }
    public Patient DeletePatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.remove(patient);
        entityManager.getTransaction().commit();
        return patient;
    }

}
