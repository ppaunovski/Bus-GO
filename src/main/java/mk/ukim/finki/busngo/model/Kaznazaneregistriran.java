package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Kaznazaneregistriran {
    private Long kzId;
    private Object kznTelefon;
    private Object kznIme;
    private Object kznAdresa;
    private Kazna kaznaByKzId;

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
    @Column(name = "kzn_telefon", nullable = true)
    public Object getKznTelefon() {
        return kznTelefon;
    }

    public void setKznTelefon(Object kznTelefon) {
        this.kznTelefon = kznTelefon;
    }

    @Basic
    @Column(name = "kzn_ime", nullable = false)
    public Object getKznIme() {
        return kznIme;
    }

    public void setKznIme(Object kznIme) {
        this.kznIme = kznIme;
    }

    @Basic
    @Column(name = "kzn_adresa", nullable = false)
    public Object getKznAdresa() {
        return kznAdresa;
    }

    public void setKznAdresa(Object kznAdresa) {
        this.kznAdresa = kznAdresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kaznazaneregistriran that = (Kaznazaneregistriran) o;
        return Objects.equals(kzId, that.kzId) && Objects.equals(kznTelefon, that.kznTelefon) && Objects.equals(kznIme, that.kznIme) && Objects.equals(kznAdresa, that.kznAdresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kzId, kznTelefon, kznIme, kznAdresa);
    }

    @OneToOne
    @JoinColumn(name = "kz_id", referencedColumnName = "kz_id", nullable = false)
    public Kazna getKaznaByKzId() {
        return kaznaByKzId;
    }

    public void setKaznaByKzId(Kazna kaznaByKzId) {
        this.kaznaByKzId = kaznaByKzId;
    }
}
