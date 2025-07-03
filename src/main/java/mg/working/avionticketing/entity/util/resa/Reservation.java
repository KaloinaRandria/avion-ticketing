package mg.working.avionticketing.entity.util.resa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.avionticketing.entity.user.Utilisateur;
import mg.working.avionticketing.entity.util.Vol;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_reservation")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur" , referencedColumnName = "id_utilisateur" , nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_vol" , referencedColumnName = "id_vol" , nullable = false)
    private Vol vol;

    @Column(name = "date_reservation")
    private LocalDateTime dateReservation;
}
