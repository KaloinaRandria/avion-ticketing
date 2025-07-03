package mg.working.avionticketing.entity.util;

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
@Table(name = "type_siege")
public class TypeSiege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_type_siege")
    private int id;
    private String libelle;
}
