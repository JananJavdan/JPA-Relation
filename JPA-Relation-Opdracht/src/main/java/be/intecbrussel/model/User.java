package be.intecbrussel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;


    @OneToMany(mappedBy = "emailAdress", cascade = CascadeType.ALL)
    private List<EmailAdress> emailAdress = new ArrayList<>();

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
