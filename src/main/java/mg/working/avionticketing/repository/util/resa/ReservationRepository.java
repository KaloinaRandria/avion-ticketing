package mg.working.avionticketing.repository.util.resa;

import mg.working.avionticketing.entity.util.resa.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Integer> {
}
