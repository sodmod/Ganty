package GantyRex.Ganty.Customers_Info.Guarantors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Guarantors {

    @Id
    @SequenceGenerator(
            name = "guarantors_sequence",
            sequenceName = "guarantors_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "guarantors_sequence")
    private Long Id;
    private String firstname;
    private String surname;
    private Long phoneNumber;
    private String Address;
    private String STATE_OF_ORIGIN;
    private String LGA;
    private String occupation;

}
