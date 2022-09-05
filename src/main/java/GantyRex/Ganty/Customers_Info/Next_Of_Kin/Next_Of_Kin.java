package GantyRex.Ganty.Customers_Info.Next_Of_Kin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Next_Of_Kin {

    @Id
    @SequenceGenerator(
            name = "NextOfKin_sequence",
            sequenceName = "NextOfKin_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "NextOfKin_sequence")
    private Long Id;
    private String surname;
    private String lastname;
    private String Address;
    private String STATE_OF_ORIGIN;
    private String LGA;
    private Long phoneNumber;
//    private
}
