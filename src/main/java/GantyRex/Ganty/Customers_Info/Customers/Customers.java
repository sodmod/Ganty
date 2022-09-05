package GantyRex.Ganty.Customers_Info.Customers;

import GantyRex.Ganty.Customers_Info.Guarantors.Guarantors;
import GantyRex.Ganty.Customers_Info.Next_Of_Kin.Next_Of_Kin;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Entity
public class Customers {

    @Id
    @SequenceGenerator(
            name = "customers_sequence",
            sequenceName = "customers_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "customers_sequence")
    private Long id;
    private String surname;
    private String firstname;
    private String email;
    private String phoneNumber;
    private String Address;
    private String STATE_OF_ORIGIN;
    private String LCGA;
    private String Occupation;
    @OneToMany
    @JoinColumn(
            name = "guarantors_Id",
            nullable = false
    )
    private Set<Guarantors> guarantors;

    @OneToOne
    @JoinColumn(
            name = "nextOfKin_Id",
            nullable = false
    )
    private Next_Of_Kin nextOfKin;
//    private String Age;

    public Customers(String surname, String firstname,
                     String email, String phoneNumber,
                     String Address, String STATE_OF_ORIGIN,
                     String LCGA, String Occupation,
                     Set<Guarantors> guarantors, Next_Of_Kin nextOfKin){
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Address = Address;
        this.STATE_OF_ORIGIN = STATE_OF_ORIGIN;
        this.LCGA = LCGA;
        this.Occupation = Occupation;
        this.guarantors = guarantors;
        this.nextOfKin = nextOfKin;
    }

//    @OneToOne
//    @JoinColumn(
//            name = "staffs_id",
//            nullable = false
//    )
//    private Staffs staffs;
}
