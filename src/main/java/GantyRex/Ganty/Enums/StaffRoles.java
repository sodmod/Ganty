package GantyRex.Ganty.Enums;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static GantyRex.Ganty.Enums.Permission.*;

@Getter
public enum StaffRoles {
    MANAGER(Sets.newHashSet(WRITE, READ, DELETE, UPDATE)),
    HOD(Sets.newHashSet()),
    STAFF(Sets.newHashSet());
//    CUSTOMERS(Sets.newHashSet());

    private final Set<Permission> permissions;

    StaffRoles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities(){
      Set<GrantedAuthority> permission = getPermissions().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());

        permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permission;
    }
}
