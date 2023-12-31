package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Kaznazaregistriran {
    private Long kzId;
    private Long patnikKId;
    private Kazna kaznaByKzId;
    private Korisnik korisnikByPatnikKId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kz_id", nullable = false)
    public Long getKzId() {
        return kzId;
    }

    public void setKzId(Long kzId) {
        this.kzId = kzId;
    }

    @Basic
    @Column(name = "patnik_k_id", nullable = true)
    public Long getPatnikKId() {
        return patnikKId;
    }

    public void setPatnikKId(Long patnikKId) {
        this.patnikKId = patnikKId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kaznazaregistriran that = (Kaznazaregistriran) o;
        return Objects.equals(kzId, that.kzId) && Objects.equals(patnikKId, that.patnikKId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kzId, patnikKId);
    }

    @OneToOne
    @JoinColumn(name = "kz_id", referencedColumnName = "kz_id", nullable = false)
    public Kazna getKaznaByKzId() {
        return kaznaByKzId;
    }

    public void setKaznaByKzId(Kazna kaznaByKzId) {
        this.kaznaByKzId = kaznaByKzId;
    }

    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    public Korisnik getKorisnikByPatnikKId() {
        return korisnikByPatnikKId;
    }

    public void setKorisnikByPatnikKId(Korisnik korisnikByPatnikKId) {
        this.korisnikByPatnikKId = korisnikByPatnikKId;
    }
}
