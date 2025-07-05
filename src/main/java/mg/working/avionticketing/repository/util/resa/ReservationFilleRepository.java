package mg.working.avionticketing.repository.util.resa;

import mg.working.avionticketing.entity.util.resa.ReservationFille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationFilleRepository extends JpaRepository<ReservationFille , Integer> {
}
