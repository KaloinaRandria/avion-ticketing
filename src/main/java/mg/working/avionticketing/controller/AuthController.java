package mg.working.avionticketing.controller;

import jakarta.servlet.http.HttpSession;
import mg.working.avionticketing.entity.user.Utilisateur;
import mg.working.avionticketing.service.auth.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping("/login-page")
    public String goToLoginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(name = "email") String email,
                            @RequestParam(name = "password") String password,
                            HttpSession session,
                            Model model) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            model.addAttribute("error", "Email et mot de passe doivent être renseignés.");
            return "auth/login";
        }

        Utilisateur utilisateur = utilisateurService.getUtilisateurByEmailAndMotDePasse(email , password);
        if (utilisateur != null) {
            session.setAttribute("user" , utilisateur);
            return "redirect:/dashboard";
        }
        model.addAttribute("error" , "Email ou Mot de Passe incorrect.");
        return "auth/login";
    }

    @GetMapping("/sign-up-page")
    public String goToSignUpPage() {
        return "auth/sign-up";
    }

    @PostMapping("/save")
    public String signIUtilisateur(@RequestParam(name = "nom") String nom,
                                   @RequestParam(name = "email") String email,
                                   @RequestParam(name = "motDePasse") String motDePasse,
                                   @RequestParam(name = "statut") String status,
                                   RedirectAttributes redirectAttributes) {

        if (nom == null || nom.isEmpty()
        || email == null || email.isEmpty()
        || motDePasse == null || motDePasse.isEmpty()
        || status == null || status.isEmpty()) {
            redirectAttributes.addFlashAttribute("message" , "Champs Incomplet.");
            return "redirect:/sign-up-page";
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setStatut(Integer.valueOf(status));

        utilisateurService.insertUtilisateur(utilisateur);
        redirectAttributes.addFlashAttribute("message", "Utilisateur créé avec succès !");
        return "redirect:/sign-up-page";
    }
}
