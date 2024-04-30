package be.intecbrussel.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rijksregisternummer")
    private String rijksregisternummer;


    private String naam;
    private boolean sick;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Patient patient;

    public Patient() {
    }

    public Patient(int id, String rijksregisternummer, String naam, boolean sick, Patient patient) {
        this.id = id;
        this.rijksregisternummer = rijksregisternummer;
        this.naam = naam;
        this.sick = sick;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRijksregisternummer() {
        return rijksregisternummer;
    }

    public void setRijksregisternummer(String rijksregisternummer) {
        this.rijksregisternummer = rijksregisternummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", rijksregisternummer='" + rijksregisternummer + '\'' +
                ", naam='" + naam + '\'' +
                ", sick=" + sick +
                ", patient=" + patient +
                '}';
    }
}
