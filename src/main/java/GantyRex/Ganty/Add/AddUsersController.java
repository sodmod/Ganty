package GantyRex.Ganty.Add;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "administrator/staffs")
public class AddUsersController {
    AddStaffServices addStaffServices;

    @PostMapping(path = "admin")
    public String addAdmin(@RequestBody AddStaffs admin) {
        return addStaffServices.signupUserManager(admin);
    }

    @PostMapping(path = "hod")
    public String addHod(@RequestBody AddStaffs staffs) {
        return addStaffServices.signupUserHOD(staffs);
    }
}
