package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Postojkanalinija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pnl_id")
    private Long pnlId;
    @Basic
    @Column(name = "pnl_reden_broj")
    private Short pnlRedenBroj;
    @ManyToOne
    @JoinColumn(name = "li_id", referencedColumnName = "li_id", nullable = false)
    private Linija linijaByLiId;
    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id", nullable = false)
    private Postojka postojkaByPId;
    @OneToMany(mappedBy = "postojkanalinijaByKacuvaPnlId")
    private List<Vozenje> vozenjesByPnlId;
}
