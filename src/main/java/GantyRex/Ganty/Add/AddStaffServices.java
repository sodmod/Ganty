package GantyRex.Ganty.Add;

import GantyRex.Ganty.Users.StaffServices;
import GantyRex.Ganty.Users.Staffs;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static GantyRex.Ganty.Enums.StaffRoles.*;

@Service
@AllArgsConstructor
@Component
public class AddStaffServices {

    @Autowired
    private final StaffServices staffServices;
    public String signupUserManager(@NotNull AddStaffs staffs) {
        String staff =  staffServices.addStaff(
                new Staffs(staffs.getFirstname(), staffs.getSurname(),
                        staffs.getEmail(), staffs.getPassword(),
                        MANAGER
                )
        );
        return staff;
    }

    public String signupUserHOD(@NotNull AddStaffs staffs) {
        String staff =  staffServices.addStaff(
                new Staffs(staffs.getFirstname(), staffs.getSurname(),
                        staffs.getEmail(), staffs.getPassword(),
                        HOD
                )
        );
        return staff;
    }
}
