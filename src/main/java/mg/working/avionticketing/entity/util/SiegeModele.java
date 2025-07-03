package mg.working.avionticketing.entity.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.avionticketing.entity.avion.Modele;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siege_modele")
public class SiegeModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_siege_modele")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_modele" , referencedColumnName = "id_modele")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "id_type_siege" , referencedColumnName = "id_type_siege")
    private TypeSiege typeSiege; //business , eco

    @Column(name = "nb_siege")
    private int nbSiege;
}
