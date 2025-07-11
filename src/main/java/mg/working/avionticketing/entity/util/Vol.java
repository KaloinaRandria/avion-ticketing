package mg.working.avionticketing.entity.util;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.avionticketing.entity.avion.Avion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vol")
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vol")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_avion", referencedColumnName = "id_avion", nullable = false)
    private Avion avion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ville_depart", referencedColumnName = "id_ville", nullable = false)
    private Ville villeDepart;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ville_arrivee", referencedColumnName = "id_ville", nullable = false)
    private Ville villeArrivee;

    @NotNull
    @Column(name = "date_depart", nullable = false)
    private LocalDateTime dateDepart;

    @NotNull
    @Column(name = "date_arrivee", nullable = false)
    private LocalDateTime dateArrivee;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 10, fraction = 2)
    @Column(name = "prix_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal prixBase;

    public void setPrixBase(String prixBaseString) {
        this.prixBase = new BigDecimal(prixBaseString);
    }

    public void setDateDepart(String dateDepartString) {
        this.dateDepart = LocalDateTime.parse(dateDepartString);
    }

    public void setDateArrivee(String dateArriveeString) {
        this.dateArrivee = LocalDateTime.parse(dateArriveeString);
    }

}
