package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Kazna {
    private Long kzId;
    private Double kzIznos;
    private Boolean kzPlateno;
    private Timestamp kzDatum;
    private Timestamp kzDatumPlateno;
    private String kzDokument;
    private Long kondukterKId;
    private Long kontrolaId;
    private Korisnik korisnikByKondukterKId;
    private Kontroli kontroliByKontrolaId;
    private Kaznazaneregistriran kaznazaneregistriranByKzId;
    private Kaznazaregistriran kaznazaregistriranByKzId;

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
    @Column(name = "kz_iznos", nullable = false, precision = 0)
    public Double getKzIznos() {
        return kzIznos;
    }

    public void setKzIznos(Double kzIznos) {
        this.kzIznos = kzIznos;
    }

    @Basic
    @Column(name = "kz_plateno", nullable = false)
    public Boolean getKzPlateno() {
        return kzPlateno;
    }

    public void setKzPlateno(Boolean kzPlateno) {
        this.kzPlateno = kzPlateno;
    }

    @Basic
    @Column(name = "kz_datum", nullable = false)
    public Timestamp getKzDatum() {
        return kzDatum;
    }

    public void setKzDatum(Timestamp kzDatum) {
        this.kzDatum = kzDatum;
    }

    @Basic
    @Column(name = "kz_datum_plateno", nullable = true)
    public Timestamp getKzDatumPlateno() {
        return kzDatumPlateno;
    }

    public void setKzDatumPlateno(Timestamp kzDatumPlateno) {
        this.kzDatumPlateno = kzDatumPlateno;
    }

    @Basic
    @Column(name = "kz_dokument", nullable = false)
    public String getKzDokument() {
        return kzDokument;
    }

    public void setKzDokument(String kzDokument) {
        this.kzDokument = kzDokument;
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
    @Column(name = "kontrola_id", nullable = true)
    public Long getKontrolaId() {
        return kontrolaId;
    }

    public void setKontrolaId(Long kontrolaId) {
        this.kontrolaId = kontrolaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kazna kazna = (Kazna) o;
        return Objects.equals(kzId, kazna.kzId) && Objects.equals(kzIznos, kazna.kzIznos) && Objects.equals(kzPlateno, kazna.kzPlateno) && Objects.equals(kzDatum, kazna.kzDatum) && Objects.equals(kzDatumPlateno, kazna.kzDatumPlateno) && Objects.equals(kzDokument, kazna.kzDokument) && Objects.equals(kondukterKId, kazna.kondukterKId) && Objects.equals(kontrolaId, kazna.kontrolaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kzId, kzIznos, kzPlateno, kzDatum, kzDatumPlateno, kzDokument, kondukterKId, kontrolaId);
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
    @JoinColumn(name = "kontrola_id", referencedColumnName = "kontrola_id")
    public Kontroli getKontroliByKontrolaId() {
        return kontroliByKontrolaId;
    }

    public void setKontroliByKontrolaId(Kontroli kontroliByKontrolaId) {
        this.kontroliByKontrolaId = kontroliByKontrolaId;
    }

    @OneToOne(mappedBy = "kaznaByKzId")
    public Kaznazaneregistriran getKaznazaneregistriranByKzId() {
        return kaznazaneregistriranByKzId;
    }

    public void setKaznazaneregistriranByKzId(Kaznazaneregistriran kaznazaneregistriranByKzId) {
        this.kaznazaneregistriranByKzId = kaznazaneregistriranByKzId;
    }

    @OneToOne(mappedBy = "kaznaByKzId")
    public Kaznazaregistriran getKaznazaregistriranByKzId() {
        return kaznazaregistriranByKzId;
    }

    public void setKaznazaregistriranByKzId(Kaznazaregistriran kaznazaregistriranByKzId) {
        this.kaznazaregistriranByKzId = kaznazaregistriranByKzId;
    }
}
