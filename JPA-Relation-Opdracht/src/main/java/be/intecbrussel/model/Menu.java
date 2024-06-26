package be.intecbrussel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private boolean paid;
    private boolean vegetarian;


    @ManyToMany(mappedBy = "menus")
    private List<Customer> customers = new ArrayList<Customer>();

}
