package GantyRex.Ganty.Customers_Info.Customers;

import GantyRex.Ganty.Customers_Info.Guarantors.Guarantors;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
//    @GeneratedValue(strategy = SEQUENCE, generator = "customers_sequence")
    @GeneratedValue
    private Long id;
    private String surname;
    private String firstname;
    private String email;
    private String phoneNumber;
    private String Address;
    private String STATE_OF_ORIGIN;
    private String LCGA;
    private String Occupation;
    @OneToMany(targetEntity = Guarantors.class, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "guarantors_Id",
            nullable = false
    )
    private List<Guarantors> guarantors;

    public Customers(String surname, String firstname,
                     String email, String phoneNumber,
                     String Address, String STATE_OF_ORIGIN,
                     String LCGA, String Occupation,
                     List<Guarantors> guarantors){
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Address = Address;
        this.STATE_OF_ORIGIN = STATE_OF_ORIGIN;
        this.LCGA = LCGA;
        this.Occupation = Occupation;
        this.guarantors = guarantors;
    }


}
