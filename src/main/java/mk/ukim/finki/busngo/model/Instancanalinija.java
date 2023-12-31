package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Instancanalinija {
    private Long inlId;
    private Timestamp inlDatumStart;
    private Timestamp inlDatumEnd;
    private Long vozacKId;
    private String aRegistracija;
    private Integer liId;
    private Korisnik korisnikByVozacKId;
    private Avtobus avtobusByARegistracija;
    private Linija linijaByLiId;
    private Collection<Vozenje> vozenjesByInlId;
    private Collection<Kontroli> kontrolisByInlId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inl_id", nullable = false)
    public Long getInlId() {
        return inlId;
    }

    public void setInlId(Long inlId) {
        this.inlId = inlId;
    }

    @Basic
    @Column(name = "inl_datum_start", nullable = false)
    public Timestamp getInlDatumStart() {
        return inlDatumStart;
    }

    public void setInlDatumStart(Timestamp inlDatumStart) {
        this.inlDatumStart = inlDatumStart;
    }

    @Basic
    @Column(name = "inl_datum_end", nullable = true)
    public Timestamp getInlDatumEnd() {
        return inlDatumEnd;
    }

    public void setInlDatumEnd(Timestamp inlDatumEnd) {
        this.inlDatumEnd = inlDatumEnd;
    }

    @Basic
    @Column(name = "vozac_k_id", nullable = false)
    public Long getVozacKId() {
        return vozacKId;
    }

    public void setVozacKId(Long vozacKId) {
        this.vozacKId = vozacKId;
    }

    @Basic
    @Column(name = "a_registracija", nullable = true, length = 8)
    public String getaRegistracija() {
        return aRegistracija;
    }

    public void setaRegistracija(String aRegistracija) {
        this.aRegistracija = aRegistracija;
    }

    @Basic
    @Column(name = "li_id", nullable = false)
    public Integer getLiId() {
        return liId;
    }

    public void setLiId(Integer liId) {
        this.liId = liId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instancanalinija that = (Instancanalinija) o;
        return Objects.equals(inlId, that.inlId) && Objects.equals(inlDatumStart, that.inlDatumStart) && Objects.equals(inlDatumEnd, that.inlDatumEnd) && Objects.equals(vozacKId, that.vozacKId) && Objects.equals(aRegistracija, that.aRegistracija) && Objects.equals(liId, that.liId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inlId, inlDatumStart, inlDatumEnd, vozacKId, aRegistracija, liId);
    }

    @ManyToOne
    @JoinColumn(name = "vozac_k_id", referencedColumnName = "k_id", nullable = false)
    public Korisnik getKorisnikByVozacKId() {
        return korisnikByVozacKId;
    }

    public void setKorisnikByVozacKId(Korisnik korisnikByVozacKId) {
        this.korisnikByVozacKId = korisnikByVozacKId;
    }

    @ManyToOne
    @JoinColumn(name = "a_registracija", referencedColumnName = "a_registracija")
    public Avtobus getAvtobusByARegistracija() {
        return avtobusByARegistracija;
    }

    public void setAvtobusByARegistracija(Avtobus avtobusByARegistracija) {
        this.avtobusByARegistracija = avtobusByARegistracija;
    }

    @ManyToOne
    @JoinColumn(name = "li_id", referencedColumnName = "li_id", nullable = false)
    public Linija getLinijaByLiId() {
        return linijaByLiId;
    }

    public void setLinijaByLiId(Linija linijaByLiId) {
        this.linijaByLiId = linijaByLiId;
    }

    @OneToMany(mappedBy = "instancanalinijaByInlId")
    public Collection<Vozenje> getVozenjesByInlId() {
        return vozenjesByInlId;
    }

    public void setVozenjesByInlId(Collection<Vozenje> vozenjesByInlId) {
        this.vozenjesByInlId = vozenjesByInlId;
    }

    @OneToMany(mappedBy = "instancanalinijaByInlId")
    public Collection<Kontroli> getKontrolisByInlId() {
        return kontrolisByInlId;
    }

    public void setKontrolisByInlId(Collection<Kontroli> kontrolisByInlId) {
        this.kontrolisByInlId = kontrolisByInlId;
    }
}
