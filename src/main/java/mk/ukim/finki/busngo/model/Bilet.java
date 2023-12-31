package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bilet {
    private Long bId;
    private Timestamp bDatumNaKupuvanje;
    private BILET_STATUS bStatus;
    private Long patnikKId;
    private Long tbId;
    private Korisnik korisnikByPatnikKId;
    private Tipbilet tipbiletByTbId;
    private Collection<Vozenje> vozenjesByBId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "b_id", nullable = false)
    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    @Basic
    @Column(name = "b_datum_na_kupuvanje", nullable = false)
    public Timestamp getbDatumNaKupuvanje() {
        return bDatumNaKupuvanje;
    }

    public void setbDatumNaKupuvanje(Timestamp bDatumNaKupuvanje) {
        this.bDatumNaKupuvanje = bDatumNaKupuvanje;
    }

    @Basic
    @Column(name = "b_status", nullable = false)
    @Enumerated(EnumType.STRING)
    public BILET_STATUS getbStatus() {
        return bStatus;
    }

    public void setbStatus(BILET_STATUS bStatus) {
        this.bStatus = bStatus;
    }

    @Basic
    @Column(name = "patnik_k_id", nullable = true)
    public Long getPatnikKId() {
        return patnikKId;
    }

    public void setPatnikKId(Long patnikKId) {
        this.patnikKId = patnikKId;
    }

    @Basic
    @Column(name = "tb_id", nullable = true)
    public Long getTbId() {
        return tbId;
    }

    public void setTbId(Long tbId) {
        this.tbId = tbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilet bilet = (Bilet) o;
        return Objects.equals(bId, bilet.bId) && Objects.equals(bDatumNaKupuvanje, bilet.bDatumNaKupuvanje) && Objects.equals(bStatus, bilet.bStatus) && Objects.equals(patnikKId, bilet.patnikKId) && Objects.equals(tbId, bilet.tbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bId, bDatumNaKupuvanje, bStatus, patnikKId, tbId);
    }

    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    public Korisnik getKorisnikByPatnikKId() {
        return korisnikByPatnikKId;
    }

    public void setKorisnikByPatnikKId(Korisnik korisnikByPatnikKId) {
        this.korisnikByPatnikKId = korisnikByPatnikKId;
    }

    @ManyToOne
    @JoinColumn(name = "tb_id", referencedColumnName = "tb_id")
    public Tipbilet getTipbiletByTbId() {
        return tipbiletByTbId;
    }

    public void setTipbiletByTbId(Tipbilet tipbiletByTbId) {
        this.tipbiletByTbId = tipbiletByTbId;
    }

    @OneToMany(mappedBy = "biletByBId")
    public Collection<Vozenje> getVozenjesByBId() {
        return vozenjesByBId;
    }

    public void setVozenjesByBId(Collection<Vozenje> vozenjesByBId) {
        this.vozenjesByBId = vozenjesByBId;
    }
}
