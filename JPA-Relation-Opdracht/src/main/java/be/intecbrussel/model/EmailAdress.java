package be.intecbrussel.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class EmailAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user-id")
    private User user;

    public EmailAdress() {
    }

    public EmailAdress(String email, User user) {
        this.email = email;
        this.user = user;
    }

    public EmailAdress(String mail) {
    }
}
