package mg.working.avionticketing.repository.avion;

import mg.working.avionticketing.entity.avion.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion , Integer> {
}
