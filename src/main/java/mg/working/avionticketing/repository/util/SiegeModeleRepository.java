package mg.working.avionticketing.repository.util;

import mg.working.avionticketing.entity.util.SiegeModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiegeModeleRepository extends JpaRepository<SiegeModele , Integer> {
}
