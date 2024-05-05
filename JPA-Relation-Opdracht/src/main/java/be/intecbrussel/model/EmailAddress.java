package be.intecbrussel.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class EmailAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Id-kolom, aangenomen dat je een id nodig hebt

    @Column(name = "email", length = 255)  // Definieer de email-kolom met een maximale lengte van 255 tekens
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Geen streepje nodig in de kolomnaam voor joincolumn
    private User user;

    public EmailAddress(String email) {
        this.email = email;
    }

}
