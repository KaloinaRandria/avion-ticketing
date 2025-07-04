package mg.working.avionticketing.repository.auth;

import mg.working.avionticketing.entity.user.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
