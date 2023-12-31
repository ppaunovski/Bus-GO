package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Kontroli {
    private Long kontrolaId;
    private Timestamp kontrolaDatum;
    private Long kondukterKId;
    private Long inlId;
    private Korisnik korisnikByKondukterKId;
    private Instancanalinija instancanalinijaByInlId;
    private Collection<Kazna> kaznasByKontrolaId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kontrola_id", nullable = false)
    public Long getKontrolaId() {
        return kontrolaId;
    }

    public void setKontrolaId(Long kontrolaId) {
        this.kontrolaId = kontrolaId;
    }

    @Basic
    @Column(name = "kontrola_datum", nullable = false)
    public Timestamp getKontrolaDatum() {
        return kontrolaDatum;
    }

    public void setKontrolaDatum(Timestamp kontrolaDatum) {
        this.kontrolaDatum = kontrolaDatum;
    }

    @Basic
    @Column(name = "kondukter_k_id", nullable = true)
    public Long getKondukterKId() {
        return kondukterKId;
    }

    public void setKondukterKId(Long kondukterKId) {
        this.kondukterKId = kondukterKId;
    }

    @Basic
    @Column(name = "inl_id", nullable = true)
    public Long getInlId() {
        return inlId;
    }

    public void setInlId(Long inlId) {
        this.inlId = inlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kontroli kontroli = (Kontroli) o;
        return Objects.equals(kontrolaId, kontroli.kontrolaId) && Objects.equals(kontrolaDatum, kontroli.kontrolaDatum) && Objects.equals(kondukterKId, kontroli.kondukterKId) && Objects.equals(inlId, kontroli.inlId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kontrolaId, kontrolaDatum, kondukterKId, inlId);
    }

    @ManyToOne
    @JoinColumn(name = "kondukter_k_id", referencedColumnName = "k_id")
    public Korisnik getKorisnikByKondukterKId() {
        return korisnikByKondukterKId;
    }

    public void setKorisnikByKondukterKId(Korisnik korisnikByKondukterKId) {
        this.korisnikByKondukterKId = korisnikByKondukterKId;
    }

    @ManyToOne
    @JoinColumn(name = "inl_id", referencedColumnName = "inl_id")
    public Instancanalinija getInstancanalinijaByInlId() {
        return instancanalinijaByInlId;
    }

    public void setInstancanalinijaByInlId(Instancanalinija instancanalinijaByInlId) {
        this.instancanalinijaByInlId = instancanalinijaByInlId;
    }

    @OneToMany(mappedBy = "kontroliByKontrolaId")
    public Collection<Kazna> getKaznasByKontrolaId() {
        return kaznasByKontrolaId;
    }

    public void setKaznasByKontrolaId(Collection<Kazna> kaznasByKontrolaId) {
        this.kaznasByKontrolaId = kaznasByKontrolaId;
    }
}
