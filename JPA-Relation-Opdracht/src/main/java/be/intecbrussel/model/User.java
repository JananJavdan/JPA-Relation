package be.intecbrussel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;

    @OneToMany(mappedBy = "emailAdress", cascade = CascadeType.ALL)
    private List<EmailAdress> emailAdress = new ArrayList<>()

    public User() {
    }

    public User(int id, String firstName, List<EmailAdress> emailAdress) {
        this.id = id;
        this.firstName = firstName;
        this.emailAdress = emailAdress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<EmailAdress> getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(List<EmailAdress> emailAdress) {
        this.emailAdress = emailAdress;
    }

}
