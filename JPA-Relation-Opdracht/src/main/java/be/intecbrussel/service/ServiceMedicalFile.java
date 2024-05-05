package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.MedicalFile;
import be.intecbrussel.model.Patient;
import be.intecbrussel.repository.RepositoryMedicalFile;
import be.intecbrussel.repository.RepositoryPatient;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ServiceMedicalFile {
    private RepositoryMedicalFile repositoryMedicalFile = new RepositoryMedicalFile();

    public void createMedicalFile(MedicalFile medicalFile) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        repositoryMedicalFile.createMedicalFile(entityManager, medicalFile);
        entityManager.close();
    }

    public Optional<MedicalFile> findMedicalFile(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<MedicalFile> medicalFile = repositoryMedicalFile.findMedicalFile(entityManager, id);
        entityManager.close();
        return medicalFile;
    }

    public void updateMedicalFile(MedicalFile medicalFile) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        int medicalFileIdId = medicalFile.getId();
        Optional<MedicalFile> optionalMedicalFile = repositoryMedicalFile.findMedicalFile(entityManager, medicalFileIdId);
        if (optionalMedicalFile.isEmpty()) {
            entityManager.close();
            return;
        }
    }
    public void deleteMedicalFile(int id)
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Optional<MedicalFile> medicalFile = repositoryMedicalFile.findMedicalFile(entityManager,id);
        if(medicalFile.isPresent()) {
            repositoryMedicalFile.deleteMedicalFile(entityManager, medicalFile.get());
        }
        else {
            System.out.println("not found");
        }
        entityManager.close();
    }
}
