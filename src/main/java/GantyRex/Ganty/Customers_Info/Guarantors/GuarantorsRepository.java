package GantyRex.Ganty.Customers_Info.Guarantors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarantorsRepository extends JpaRepository<Guarantors, Long> {
}
