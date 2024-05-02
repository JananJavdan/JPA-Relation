package be.intecbrussel.service;

import be.intecbrussel.repository.RepositoryPatientMedicalFile;

import javax.persistence.EntityManager;

public class ServicePatientMedicalFile {

    private RepositoryPatientMedicalFile repositoryPatientMedicalFile;
    private EntityManager entityManager;

    public ServicePatientMedicalFile(RepositoryPatientMedicalFile repositoryPatientMedicalFile, EntityManager entityManager) {
        this.repositoryPatientMedicalFile = repositoryPatientMedicalFile;
    }
    public void createPatientMedicalFile() {
        entityManager.getTransaction().begin();
        entityManager.persist(repositoryPatientMedicalFile);
        entityManager.getTransaction().commit();
    }
    public void updatePatientMedicalFile() {
        entityManager.getTransaction().begin();
        entityManager.merge(repositoryPatientMedicalFile);
        entityManager.getTransaction().commit();
    }
    public void deletePatientMedicalFile() {
        entityManager.getTransaction().begin();
        entityManager.remove(repositoryPatientMedicalFile);
        entityManager.getTransaction().commit();
    }

}
