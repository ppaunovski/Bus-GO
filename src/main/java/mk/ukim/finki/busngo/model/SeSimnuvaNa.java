package mk.ukim.finki.busngo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "se_simnuva_na", schema = "project", catalog = "db_202324z_va_prj_busngo")
@jakarta.persistence.IdClass(mk.ukim.finki.busngo.model.SeSimnuvaNaPK.class)
public class SeSimnuvaNa {
    private Long pnlId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "pnl_id", nullable = false)
    public Long getPnlId() {
        return pnlId;
    }

    public void setPnlId(Long pnlId) {
        this.pnlId = pnlId;
    }

    private Long vozenjeId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "vozenje_id", nullable = false)
    public Long getVozenjeId() {
        return vozenjeId;
    }

    public void setVozenjeId(Long vozenjeId) {
        this.vozenjeId = vozenjeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeSimnuvaNa that = (SeSimnuvaNa) o;
        return Objects.equals(pnlId, that.pnlId) && Objects.equals(vozenjeId, that.vozenjeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pnlId, vozenjeId);
    }
}
