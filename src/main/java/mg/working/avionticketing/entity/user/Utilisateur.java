package mg.working.avionticketing.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_utilisateur")
    private int id;
    private String nom;
    private String email;
    @Column(name = "mot_de_passe")
    private String motDePasse;
    private int statut; //admin , client
}
