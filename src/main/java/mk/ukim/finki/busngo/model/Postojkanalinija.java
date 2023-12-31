package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Postojkanalinija {
    private Long pnlId;
    private Short pnlRedenBroj;
    private Integer liId;
    private Integer pId;
    private Linija linijaByLiId;
    private Postojka postojkaByPId;
    private Collection<Vozenje> vozenjesByPnlId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pnl_id", nullable = false)
    public Long getPnlId() {
        return pnlId;
    }

    public void setPnlId(Long pnlId) {
        this.pnlId = pnlId;
    }

    @Basic
    @Column(name = "pnl_reden_broj", nullable = false)
    public Short getPnlRedenBroj() {
        return pnlRedenBroj;
    }

    public void setPnlRedenBroj(Short pnlRedenBroj) {
        this.pnlRedenBroj = pnlRedenBroj;
    }

    @Basic
    @Column(name = "li_id", nullable = false)
    public Integer getLiId() {
        return liId;
    }

    public void setLiId(Integer liId) {
        this.liId = liId;
    }

    @Basic
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postojkanalinija that = (Postojkanalinija) o;
        return Objects.equals(pnlId, that.pnlId) && Objects.equals(pnlRedenBroj, that.pnlRedenBroj) && Objects.equals(liId, that.liId) && Objects.equals(pId, that.pId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pnlId, pnlRedenBroj, liId, pId);
    }

    @ManyToOne
    @JoinColumn(name = "li_id", referencedColumnName = "li_id", nullable = false)
    public Linija getLinijaByLiId() {
        return linijaByLiId;
    }

    public void setLinijaByLiId(Linija linijaByLiId) {
        this.linijaByLiId = linijaByLiId;
    }

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id", nullable = false)
    public Postojka getPostojkaByPId() {
        return postojkaByPId;
    }

    public void setPostojkaByPId(Postojka postojkaByPId) {
        this.postojkaByPId = postojkaByPId;
    }

    @OneToMany(mappedBy = "postojkanalinijaByKacuvaPnlId")
    public Collection<Vozenje> getVozenjesByPnlId() {
        return vozenjesByPnlId;
    }

    public void setVozenjesByPnlId(Collection<Vozenje> vozenjesByPnlId) {
        this.vozenjesByPnlId = vozenjesByPnlId;
    }
}
