package be.intecbrussel;

import be.intecbrussel.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Relation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<EmailAdress> emailAdresses = new ArrayList<>();
        emailAdresses.add(new EmailAdress("Johndoe@gmail.com"));
        emailAdresses.add(new EmailAdress("tonyels@gmail.com"));


        User user = new User(1, "John Doe", emailAdresses);
        User user2 = new User(2, "Tony Els", emailAdresses);

        entityManager.persist(user);
        entityManager.persist(user2);

        Patient patient = new Patient();
        patient.setRijksregisternummer("87876T87678");
        patient.setNaam("Loreal");
        patient.setSick(true);

        MedicalFile medicalFile = new MedicalFile();
        medicalFile.setId(1);
        medicalFile.setIllnes("Fever");
        medicalFile.setPatient(patient);

        entityManager.persist(patient);

        Menu menu = new Menu();
        menu.setPrice(22.22);
        menu.setId(1);
        menu.setPaid(true);
        menu.setVegetarian(true);

        Menu menu1 = new Menu();
        menu1.setPrice(44.9);
        menu1.setId(2);
        menu1.setPaid(false);
        menu1.setVegetarian(true);

        Customer customer = new Customer();
        customer.getMenus().add(menu);
        customer.getMenus().add(menu1);

        entityManager.persist(menu);
        entityManager.persist(menu1);


        entityManager.getTransaction().commit();
        entityManager.close();


    }
}