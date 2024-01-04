package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.busngo.model.enums.VOZENJE_STATUS;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
public class Vozenje {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vozenje_id")
    private Long vozenjeId;
    @Basic
    @Column(name = "vozenje_start")
    private Timestamp vozenjeStart;
    @Basic
    @Column(name = "vozenje_end")
    private Timestamp vozenjeEnd;
    @Basic
    @Column(name = "vozenje_status")
    @Enumerated(EnumType.STRING)
    private VOZENJE_STATUS vozenjeStatus;
    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    private Korisnik korisnikByPatnikKId;
    @ManyToOne
    @JoinColumn(name = "kacuva_pnl_id", referencedColumnName = "pnl_id", nullable = false)
    private Postojkanalinija postojkanalinijaByKacuvaPnlId;
    @ManyToOne
    @JoinColumn(name = "inl_id", referencedColumnName = "inl_id", nullable = false)
    private Instancanalinija instancanalinijaByInlId;
    @ManyToOne
    @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)
    private Bilet biletByBId;

}
