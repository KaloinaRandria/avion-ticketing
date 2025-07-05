package mg.working.avionticketing.repository.avion;

import mg.working.avionticketing.entity.avion.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele , Integer> {
}
