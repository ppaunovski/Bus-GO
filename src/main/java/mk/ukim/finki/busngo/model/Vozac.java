package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vozac {
    private Long kId;
    private Korisnik korisnikByKId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "k_id", nullable = false)
    public Long getkId() {
        return kId;
    }

    public void setkId(Long kId) {
        this.kId = kId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vozac vozac = (Vozac) o;
        return Objects.equals(kId, vozac.kId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kId);
    }

    @OneToOne
    @JoinColumn(name = "k_id", referencedColumnName = "k_id", nullable = false)
    public Korisnik getKorisnikByKId() {
        return korisnikByKId;
    }

    public void setKorisnikByKId(Korisnik korisnikByKId) {
        this.korisnikByKId = korisnikByKId;
    }
}
