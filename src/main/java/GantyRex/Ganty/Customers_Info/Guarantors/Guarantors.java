package GantyRex.Ganty.Customers_Info.Guarantors;

import GantyRex.Ganty.Customers_Info.Customers.Customers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Guarantors {

    @Id
    @SequenceGenerator(name = "guarantors_sequence", sequenceName = "guarantors_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "guarantors_sequence")
    private Long Id;
    private String firstname;
    private String surname;
    private Long phoneNumber;
    private String Address;
    private String STATE_OF_ORIGIN;
    private String LGA;
    private String occupation;

    @ManyToOne
    @JoinColumn(
            name = "customers_id",
            nullable = false
    )
    private Customers customers;

    public Guarantors(String firstname, String surname,
                      Long phoneNumber, String address,
                      String STATE_OF_ORIGIN, String LGA, String occupation) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.Address = address;
        this.STATE_OF_ORIGIN = STATE_OF_ORIGIN;
        this.LGA = LGA;
        this.occupation = occupation;
    }
}
