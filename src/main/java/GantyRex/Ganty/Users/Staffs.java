package GantyRex.Ganty.Users;

import GantyRex.Ganty.Enums.Permission;
import GantyRex.Ganty.Enums.StaffRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Staffs implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "staff_sequence",
            sequenceName = "staff_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "staff_sequence")
    private Long id;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    private Boolean enabled = true;
    private Boolean locked = false;
    private Boolean expired = false;
    @Enumerated(STRING)
    private StaffRoles staffRoles;
    private Permission permission;

    public Staffs(String firstname, String surname, String email, String password, StaffRoles staffRoles) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.staffRoles = staffRoles;
    }

    public Staffs(){

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(staffRoles.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
