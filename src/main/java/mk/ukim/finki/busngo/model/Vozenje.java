package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;
import mk.ukim.finki.busngo.model.enums.VOZENJE_STATUS;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Vozenje {
    private Long vozenjeId;
    private Timestamp vozenjeStart;
    private Timestamp vozenjeEnd;
    private VOZENJE_STATUS vozenjeStatus;
    private Long patnikKId;
    private Long kacuvaPnlId;
    private Long inlId;
    private Long bId;
    private Korisnik korisnikByPatnikKId;
    private Postojkanalinija postojkanalinijaByKacuvaPnlId;
    private Instancanalinija instancanalinijaByInlId;
    private Bilet biletByBId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vozenje_id", nullable = false)
    public Long getVozenjeId() {
        return vozenjeId;
    }

    public void setVozenjeId(Long vozenjeId) {
        this.vozenjeId = vozenjeId;
    }

    @Basic
    @Column(name = "vozenje_start", nullable = false)
    public Timestamp getVozenjeStart() {
        return vozenjeStart;
    }

    public void setVozenjeStart(Timestamp vozenjeStart) {
        this.vozenjeStart = vozenjeStart;
    }

    @Basic
    @Column(name = "vozenje_end", nullable = true)
    public Timestamp getVozenjeEnd() {
        return vozenjeEnd;
    }

    public void setVozenjeEnd(Timestamp vozenjeEnd) {
        this.vozenjeEnd = vozenjeEnd;
    }

    @Basic
    @Column(name = "vozenje_status", nullable = false)
    @Enumerated(EnumType.STRING)
    public VOZENJE_STATUS getVozenjeStatus() {
        return vozenjeStatus;
    }

    public void setVozenjeStatus(VOZENJE_STATUS vozenjeStatus) {
        this.vozenjeStatus = vozenjeStatus;
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
    @Column(name = "kacuva_pnl_id", nullable = false)
    public Long getKacuvaPnlId() {
        return kacuvaPnlId;
    }

    public void setKacuvaPnlId(Long kacuvaPnlId) {
        this.kacuvaPnlId = kacuvaPnlId;
    }

    @Basic
    @Column(name = "inl_id", nullable = false)
    public Long getInlId() {
        return inlId;
    }

    public void setInlId(Long inlId) {
        this.inlId = inlId;
    }

    @Basic
    @Column(name = "b_id", nullable = false)
    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vozenje vozenje = (Vozenje) o;
        return Objects.equals(vozenjeId, vozenje.vozenjeId) && Objects.equals(vozenjeStart, vozenje.vozenjeStart) && Objects.equals(vozenjeEnd, vozenje.vozenjeEnd) && Objects.equals(vozenjeStatus, vozenje.vozenjeStatus) && Objects.equals(patnikKId, vozenje.patnikKId) && Objects.equals(kacuvaPnlId, vozenje.kacuvaPnlId) && Objects.equals(inlId, vozenje.inlId) && Objects.equals(bId, vozenje.bId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vozenjeId, vozenjeStart, vozenjeEnd, vozenjeStatus, patnikKId, kacuvaPnlId, inlId, bId);
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
    @JoinColumn(name = "kacuva_pnl_id", referencedColumnName = "pnl_id", nullable = false)
    public Postojkanalinija getPostojkanalinijaByKacuvaPnlId() {
        return postojkanalinijaByKacuvaPnlId;
    }

    public void setPostojkanalinijaByKacuvaPnlId(Postojkanalinija postojkanalinijaByKacuvaPnlId) {
        this.postojkanalinijaByKacuvaPnlId = postojkanalinijaByKacuvaPnlId;
    }

    @ManyToOne
    @JoinColumn(name = "inl_id", referencedColumnName = "inl_id", nullable = false)
    public Instancanalinija getInstancanalinijaByInlId() {
        return instancanalinijaByInlId;
    }

    public void setInstancanalinijaByInlId(Instancanalinija instancanalinijaByInlId) {
        this.instancanalinijaByInlId = instancanalinijaByInlId;
    }

    @ManyToOne
    @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)
    public Bilet getBiletByBId() {
        return biletByBId;
    }

    public void setBiletByBId(Bilet biletByBId) {
        this.biletByBId = biletByBId;
    }
}
