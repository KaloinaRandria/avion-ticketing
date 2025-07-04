package mg.working.avionticketing.service.auth;

import mg.working.avionticketing.entity.user.Utilisateur;
import mg.working.avionticketing.repository.auth.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public void insertUtilisateur(Utilisateur utilisateur) {
        String rawPassword = utilisateur.getMotDePasse();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        utilisateur.setMotDePasse(encodedPassword);

        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurByEmailAndMotDePasse(String email , String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElse(null);
        if (utilisateur != null && passwordEncoder.matches(motDePasse , utilisateur.getMotDePasse())) {
            return utilisateur;
        }
        return null;
    }

}
