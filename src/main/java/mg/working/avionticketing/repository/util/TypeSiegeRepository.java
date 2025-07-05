package mg.working.avionticketing.repository.util;

import mg.working.avionticketing.entity.util.TypeSiege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSiegeRepository extends JpaRepository<TypeSiege , Integer> {
}
