package mg.working.avionticketing.entity.avion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avion")
public class Avion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_avion")
    private int id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "date_fabrication")
    private Date dateFabrication;
    @ManyToOne
    @JoinColumn(name = "id_modele" , referencedColumnName = "id_modele")
    private Modele modele;
}
