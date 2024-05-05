package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Patient;
import be.intecbrussel.repository.RepositoryPatient;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServicePatient {
    private RepositoryPatient repositoryPatientMedicalFile = new RepositoryPatient();

    public void createPatient(Patient patient) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryPatientMedicalFile.createPatient(entityManager, patient);
        entityManager.close();
    }

    public Optional<Patient> findUser(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Patient> patient = repositoryPatientMedicalFile.findPatient(entityManager, id);
        entityManager.close();
        return patient;
    }

    public void updatePatient(Patient patient) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        int patientId = patient.getId();
        Optional<Patient> optionalPatient = repositoryPatientMedicalFile.findPatient(entityManager, patientId);
        if (optionalPatient.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deletePatient(int id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<Patient> patient = repositoryPatientMedicalFile.findPatient(entityManager,id);
        if(patient.isPresent()) {
            repositoryPatientMedicalFile.deletePatient(entityManager,patient.get());
        }
        else {
            System.out.println("not found");
        }
        entityManager.close();
    }
}
