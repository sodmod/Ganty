package GantyRex.Ganty.Users;

import GantyRex.Ganty.Users.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, Long> {

    Optional<Staffs> findByEmail (String email);
}
