package be.intecbrussel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmailAdress {
    @Id
    private String email;

    @ManyToOne
    @JoinColumn(name = "user-id")
    private User user;

}
