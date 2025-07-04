package mg.working.avionticketing.repository.util;

import mg.working.avionticketing.entity.util.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville , Integer> {
}
