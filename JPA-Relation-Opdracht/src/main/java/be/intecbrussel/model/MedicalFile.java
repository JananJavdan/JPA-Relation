package be.intecbrussel.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "medicalfile")
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private String illnes;

    public MedicalFile() {
    }

    public MedicalFile(int id, Patient patient, String illnes) {
        this.id = id;
        this.patient = patient;
        this.illnes = illnes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    @Override
    public String toString() {
        return "MedicalFile{" +
                "id=" + id +
                ", patient=" + patient +
                ", illnes='" + illnes + '\'' +
                '}';
    }
}

