package mg.working.avionticketing.repository.util;

import mg.working.avionticketing.entity.util.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository<Vol , Integer> {
}
