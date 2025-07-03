package mg.working.avionticketing.entity.util.resa;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.avionticketing.entity.util.TypeSiege;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation_fille")
public class ReservationFille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_reservation_fille")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_reservation" , referencedColumnName = "id_reservation" , nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "id_type_siege" , referencedColumnName = "id_type_siege" , nullable = false)
    private TypeSiege typeSiege;

    @NotNull
    @Column(name = "numero_siege" , nullable = false)
    private String numeroSiege;

    @NotNull
    @DecimalMin(value = "0.0" , inclusive = false)
    @Digits(integer = 10 , fraction = 2)
    @Column(name = "prix" , nullable = false , precision = 10 , scale = 2)
    private BigDecimal prix;
}
