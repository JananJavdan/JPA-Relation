package be.intecbrussel;

import be.intecbrussel.model.*;
import be.intecbrussel.repository.*;
import be.intecbrussel.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        ServiceUser serviceUser = new ServiceUser();
        ServiceEmailAddress serviceEmailAddress = new ServiceEmailAddress();
        ServicePatient servicePatient = new ServicePatient();
        ServiceMedicalFile serviceMedicalFile = new ServiceMedicalFile();
        ServiceCustomer serviceCustomer = new ServiceCustomer();
        ServiceMenu serviceMenu = new ServiceMenu();

        RepositoryCustomer repositoryCustomer = new RepositoryCustomer();
        RepositoryEmailAddress repositoryEmailAddress = new RepositoryEmailAddress();
        RepositoryMedicalFile repositoryMedicalFile = new RepositoryMedicalFile();
        RepositoryMenu repositoryMenu = new RepositoryMenu();
        RepositoryPatient repositoryPatient = new RepositoryPatient();
        RepositoryUser repositoryUser = new RepositoryUser();
//inctantie with email en user
        EmailAddress emailAddress1 = new EmailAddress("johndoe@gmail.com");
        EmailAddress emailAddress2 = new EmailAddress("johndoe2@gmail.com");
        EmailAddress emailAddress3 = new EmailAddress("johndoe3@gmail.com");

        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");

        //many to one
        emailAddress1.setUser(user1);
        emailAddress2.setUser(user1);
        emailAddress3.setUser(user1);
        System.out.println("user with emailAddress");

        //create user
        serviceUser.createUser(user1);

        //create email address
        serviceEmailAddress.createEmailAddress(emailAddress1);
        serviceEmailAddress.createEmailAddress(emailAddress2);
        serviceEmailAddress.createEmailAddress(emailAddress3);

        //find email address
        Optional<EmailAddress> emailAddress = serviceEmailAddress.findEmailAddress(emailAddress1.getId());
        if (emailAddress.isPresent())
        {
            System.out.println("email address founded");
        }
        else {
            System.out.println("no email found with this user");
        }
        //find user
        Optional<User> user = serviceUser.findUser(1);
        if (user.isPresent())
        {
            System.out.println("user with id founded");
        }
        else {
            System.out.println("no user with this id");
        }
        //update emailAddress
        EmailAddress emailAddress4 = new EmailAddress("johndoe4@gmail.com");
        serviceEmailAddress.updateEmailAddress(emailAddress4);

        //update user
        User user2 = new User();
        user2.setId(2);
        serviceUser.updateUser(user2);

        //delete emailAddress
        //serviceEmailAddress.deleteEmailAddress("johndoe4@gmail.com");
        //delete user
        //serviceUser.deleteUser(2);
///////////////////////////////////////////////////////////////////////////////////////

        Patient patient1 = new Patient(1, "546541635321223", "Sara", true);
        Patient patient2 = new Patient(2, "6545213546513", "Sofi", true);
        Patient patient3 = new Patient(3, "654134636563", "Cami", true);

        MedicalFile medicalFile1 = new MedicalFile(1, "Fever", patient1);
        MedicalFile medicalFile2 = new MedicalFile(2, "Diarrhea", patient2);
        MedicalFile medicalFile3 = new MedicalFile(1, "Fatigue", patient3);

        //set medical file with patient one to one
        medicalFile1.setPatient(patient1);
        medicalFile2.setPatient(patient2);
        medicalFile3.setPatient(patient3);

        //create patient
        servicePatient.createPatient(patient1);
        servicePatient.createPatient(patient2);
        servicePatient.createPatient(patient3);

        //create medical file
        serviceMedicalFile.createMedicalFile(medicalFile1);
        serviceMedicalFile.createMedicalFile(medicalFile2);
        serviceMedicalFile.createMedicalFile(medicalFile3);

        //find medical file
        Optional<MedicalFile> medicalFile = serviceMedicalFile.findMedicalFile(1);
        if (medicalFile.isPresent()) {
            System.out.println(medicalFile.get());
        }
        else {
            System.out.println("no medical file founded");
        }
        //find patient
        Optional<Patient> patient = servicePatient.findUser(1);
        if (patient.isPresent()) {
            System.out.println(patient.get());
        }
        else {
            System.out.println("no patient with this id founded");
        }
        //update medical file
        MedicalFile medicalFile4 = new MedicalFile(4, "Coughing", patient1);
        serviceMedicalFile.updateMedicalFile(medicalFile4);
        //update patient
        Patient patient4 = new Patient(4, "343213543632", "new patient 4", true);
        servicePatient.updatePatient(patient4);
        //delete medical file
        //serviceMedicalFile.deleteMedicalFile(4);
        //delete patient
        //servicePatient.deletePatient(4);
///////////////////////////////////////////////////////////////////////////////////////////////////

        Customer customer1 = new Customer();
        customer1.setCustomerNumber(1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(2);

        Customer customer3 = new Customer();
        customer3.setCustomerNumber(3);

        Menu menu1 = new Menu();
        menu1.setPrice(22.50);
        menu1.setPaid(true);
        menu1.setVegetarian(true);

        Menu menu2 = new Menu();
        menu2.setPrice(18.75);
        menu2.setPaid(false);
        menu2.setVegetarian(false);

        Menu menu3 = new Menu();
        menu3.setPrice(30.00);
        menu3.setPaid(true);
        menu3.setVegetarian(false);
        //many to many
        customer1.getMenus().add(menu1); customer1.getMenus().add(menu2); customer1.getMenus().add(menu3);
        customer2.getMenus().add(menu1); customer2.getMenus().add(menu2); customer2.getMenus().add(menu3);
        customer3.getMenus().add(menu1); customer3.getMenus().add(menu2); customer3.getMenus().add(menu3);

        menu1.getCustomers().add(customer1); menu1.getCustomers().add(customer2); menu1.getCustomers().add(customer3);
        menu2.getCustomers().add(customer1); menu2.getCustomers().add(customer2); menu2.getCustomers().add(customer3);

        //create customer
        serviceCustomer.createCustomer(customer1);
        serviceCustomer.createCustomer(customer2);
        serviceCustomer.createCustomer(customer3);

        //create menu
        serviceMenu.createMenu(menu1);
        serviceMenu.createMenu(menu2);
        serviceMenu.createMenu(menu3);

        //find customer
        Optional<Customer> customer = serviceCustomer.findCustomer(2);
        if (customer.isPresent()) {
            System.out.println("customer founded");
        }else {
            System.out.println("no customer with this id");
        }
        //find menu
        Optional<Menu> menu  = serviceMenu.findMenu(1);
        if (menu.isPresent()){
            System.out.println(menu.get());
        }else {
            System.out.println("no menu with this id founded");
        }
        //update customer
        Customer customer4 = new Customer();
        customer4.setCustomerNumber(4);

        //update menu
        Menu menu4 = new Menu();
        menu4.setPrice(66.4);
        menu4.setPaid(true);
        menu4.setVegetarian(true);

        //delete customer
        //serviceCustomer.deleteCustomer(44444);

        //delete menu
        //serviceMenu.deleteMenu(4);
    }
}