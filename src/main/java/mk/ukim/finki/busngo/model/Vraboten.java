package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Vraboten{
    private Long kId;
    private Double vPlata;
    private Date vDatumNaVrabotuvanje;
    private Date vDatumPrekinVrabotuvanje;
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

    @Basic
    @Column(name = "v_plata", nullable = false, precision = 0)
    public Double getvPlata() {
        return vPlata;
    }

    public void setvPlata(Double vPlata) {
        this.vPlata = vPlata;
    }

    @Basic
    @Column(name = "v_datum_na_vrabotuvanje", nullable = false)
    public Date getvDatumNaVrabotuvanje() {
        return vDatumNaVrabotuvanje;
    }

    public void setvDatumNaVrabotuvanje(Date vDatumNaVrabotuvanje) {
        this.vDatumNaVrabotuvanje = vDatumNaVrabotuvanje;
    }

    @Basic
    @Column(name = "v_datum_prekin_vrabotuvanje", nullable = true)
    public Date getvDatumPrekinVrabotuvanje() {
        return vDatumPrekinVrabotuvanje;
    }

    public void setvDatumPrekinVrabotuvanje(Date vDatumPrekinVrabotuvanje) {
        this.vDatumPrekinVrabotuvanje = vDatumPrekinVrabotuvanje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return Objects.equals(kId, vraboten.kId) && Objects.equals(vPlata, vraboten.vPlata) && Objects.equals(vDatumNaVrabotuvanje, vraboten.vDatumNaVrabotuvanje) && Objects.equals(vDatumPrekinVrabotuvanje, vraboten.vDatumPrekinVrabotuvanje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kId, vPlata, vDatumNaVrabotuvanje, vDatumPrekinVrabotuvanje);
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
