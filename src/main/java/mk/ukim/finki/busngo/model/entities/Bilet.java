package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Bilet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "b_id")
    private Long bId;
    @Basic
    @Column(name = "b_datum_na_kupuvanje")
    private Timestamp bDatumNaKupuvanje;
    @Basic
    @Column(name = "b_status", columnDefinition = "string_kratok")
    @Enumerated(EnumType.STRING)
    private BILET_STATUS bStatus;
    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    private Korisnik korisnikByPatnikKId;
    @ManyToOne
    @JoinColumn(name = "tb_id", referencedColumnName = "tb_id")
    private Tipbilet tipbiletByTbId;
//    @OneToMany(mappedBy = "biletByBId")
//    private List<Vozenje> vozenjesByBId;
}
