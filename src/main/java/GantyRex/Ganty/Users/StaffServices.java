package GantyRex.Ganty.Users;

import GantyRex.Ganty.Security.PasswordConfig.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StaffServices implements UserDetailsService {
    private static final String USER_NOT_FOUND_MESSAGE = "user with email %s not found";
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return staffRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public String addStaff(@NotNull Staffs staffs) {
        boolean userExist = staffRepository.findByEmail(staffs.getEmail()).isPresent();
        if (userExist){
            throw new IllegalStateException(String.format("%s already exist", staffs.getEmail()));
        }
        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(staffs.getPassword());
        staffs.setPassword(encodedPassword);
        staffRepository.save(staffs);
        return "Okay we are good";
    }
}
