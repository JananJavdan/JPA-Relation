package be.intecbrussel.repository;

import be.intecbrussel.model.Patient;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryPatient {
    public void createPatient(EntityManager entityManager, Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }
    public Optional<Patient> findPatient(EntityManager entityManager, int id) {
        Patient optionalPatient = entityManager.find(Patient.class, id);
        return Optional.ofNullable(optionalPatient);
    }

    public void updatePatient(EntityManager entityManager, Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }

    public void deletePatient(EntityManager entityManager, Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.remove(patient);
        System.out.println("deleted");
        entityManager.getTransaction().commit();
    }

}
