package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Instancanalinija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inl_id")
    private Long inlId;
    @Basic
    @Column(name = "inl_datum_start")
    private Timestamp inlDatumStart;
    @Basic
    @Column(name = "inl_datum_end")
    private Timestamp inlDatumEnd;
    @ManyToOne
    @JoinColumn(name = "vozac_k_id", referencedColumnName = "k_id", nullable = false)
    private Korisnik korisnikByVozacKId;
    @ManyToOne
    @JoinColumn(name = "a_registracija", referencedColumnName = "a_registracija")
    private Avtobus avtobusByARegistracija;
    @ManyToOne
    @JoinColumn(name = "li_id", referencedColumnName = "li_id", nullable = false)
    private Linija linijaByLiId;
    @OneToMany(mappedBy = "instancanalinijaByInlId")
    private List<Kontroli> kontrolisByInlId;
    @OneToMany(mappedBy = "instancanalinijaByInlId")
    private List<Vozenje> vozenjesByInlId;
}
