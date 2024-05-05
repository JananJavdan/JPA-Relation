package be.intecbrussel.repository;

import be.intecbrussel.model.MedicalFile;
import be.intecbrussel.model.Patient;

import javax.persistence.EntityManager;
import java.util.Optional;

public class RepositoryMedicalFile {
    public void createMedicalFile(EntityManager entityManager, MedicalFile medicalFile) {
        entityManager.getTransaction().begin();
        entityManager.merge(medicalFile);
        entityManager.getTransaction().commit();
    }
    public Optional<MedicalFile> findMedicalFile(EntityManager entityManager, int id) {
        MedicalFile optionalMedicalFile = entityManager.find(MedicalFile.class, id);
        return Optional.ofNullable(optionalMedicalFile);
    }

    public void updateMedicalFile(EntityManager entityManager, MedicalFile medicalFile) {
        entityManager.getTransaction().begin();
        entityManager.merge(medicalFile);
        entityManager.getTransaction().commit();
    }

    public void deleteMedicalFile(EntityManager entityManager, MedicalFile medicalFile) {
        entityManager.getTransaction().begin();
        entityManager.remove(medicalFile);
        System.out.println("deleted");
        entityManager.getTransaction().commit();
    }
}
