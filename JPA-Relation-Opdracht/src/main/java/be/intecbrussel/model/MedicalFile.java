package be.intecbrussel.model;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "medicalfile")
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String illness;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


}

