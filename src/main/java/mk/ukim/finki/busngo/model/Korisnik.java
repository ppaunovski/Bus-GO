package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Korisnik {
    private Long kId;
    private String kIme;
    private String kAdresa;
    private String kTelefon;
    private String kEmail;
    private String kEmbg;
    private Boolean kIsAdmin;
    private String kLozinka;
    private Patnik patnikByKId;
    private Vraboten vrabotenByKId;
    private Kondukter kondukterByKId;
    private Vozac vozacByKId;
    private Collection<Bilet> biletsByKId;
    private Collection<Vozenje> vozenjesByKId;
    private Collection<Kontroli> kontrolisByKId;
    private Collection<Kazna> kaznasByKId;
    private Collection<Kaznazaregistriran> kaznazaregistriransByKId;

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
    @Column(name = "k_ime", nullable = false)
    public String getkIme() {
        return kIme;
    }

    public void setkIme(String kIme) {
        this.kIme = kIme;
    }

    @Basic
    @Column(name = "k_adresa", nullable = true)
    public String getkAdresa() {
        return kAdresa;
    }

    public void setkAdresa(String kAdresa) {
        this.kAdresa = kAdresa;
    }

    @Basic
    @Column(name = "k_telefon", nullable = false)
    public String getkTelefon() {
        return kTelefon;
    }

    public void setkTelefon(String kTelefon) {
        this.kTelefon = kTelefon;
    }

    @Basic
    @Column(name = "k_email", nullable = false)
    public String getkEmail() {
        return kEmail;
    }

    public void setkEmail(String kEmail) {
        this.kEmail = kEmail;
    }

    @Basic
    @Column(name = "k_embg", nullable = true, length = 13)
    public String getkEmbg() {
        return kEmbg;
    }

    public void setkEmbg(String kEmbg) {
        this.kEmbg = kEmbg;
    }

    @Basic
    @Column(name = "k_is_admin", nullable = false)
    public Boolean getkIsAdmin() {
        return kIsAdmin;
    }

    public void setkIsAdmin(Boolean kIsAdmin) {
        this.kIsAdmin = kIsAdmin;
    }

    @Basic
    @Column(name = "k_lozinka", nullable = false)
    public String getkLozinka() {
        return kLozinka;
    }

    public void setkLozinka(String kLozinka) {
        this.kLozinka = kLozinka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(kId, korisnik.kId) && Objects.equals(kIme, korisnik.kIme) && Objects.equals(kAdresa, korisnik.kAdresa) && Objects.equals(kTelefon, korisnik.kTelefon) && Objects.equals(kEmail, korisnik.kEmail) && Objects.equals(kEmbg, korisnik.kEmbg) && Objects.equals(kIsAdmin, korisnik.kIsAdmin) && Objects.equals(kLozinka, korisnik.kLozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kId, kIme, kAdresa, kTelefon, kEmail, kEmbg, kIsAdmin, kLozinka);
    }

    @OneToOne(mappedBy = "korisnikByKId")
    public Patnik getPatnikByKId() {
        return patnikByKId;
    }

    public void setPatnikByKId(Patnik patnikByKId) {
        this.patnikByKId = patnikByKId;
    }

    @OneToOne(mappedBy = "korisnikByKId")
    public Vraboten getVrabotenByKId() {
        return vrabotenByKId;
    }

    public void setVrabotenByKId(Vraboten vrabotenByKId) {
        this.vrabotenByKId = vrabotenByKId;
    }

    @OneToOne(mappedBy = "korisnikByKId")
    public Kondukter getKondukterByKId() {
        return kondukterByKId;
    }

    public void setKondukterByKId(Kondukter kondukterByKId) {
        this.kondukterByKId = kondukterByKId;
    }

    @OneToOne(mappedBy = "korisnikByKId")
    public Vozac getVozacByKId() {
        return vozacByKId;
    }

    public void setVozacByKId(Vozac vozacByKId) {
        this.vozacByKId = vozacByKId;
    }

    @OneToMany(mappedBy = "korisnikByPatnikKId")
    public Collection<Bilet> getBiletsByKId() {
        return biletsByKId;
    }

    public void setBiletsByKId(Collection<Bilet> biletsByKId) {
        this.biletsByKId = biletsByKId;
    }

    @OneToMany(mappedBy = "korisnikByPatnikKId")
    public Collection<Vozenje> getVozenjesByKId() {
        return vozenjesByKId;
    }

    public void setVozenjesByKId(Collection<Vozenje> vozenjesByKId) {
        this.vozenjesByKId = vozenjesByKId;
    }

    @OneToMany(mappedBy = "korisnikByKondukterKId")
    public Collection<Kontroli> getKontrolisByKId() {
        return kontrolisByKId;
    }

    public void setKontrolisByKId(Collection<Kontroli> kontrolisByKId) {
        this.kontrolisByKId = kontrolisByKId;
    }

    @OneToMany(mappedBy = "korisnikByKondukterKId")
    public Collection<Kazna> getKaznasByKId() {
        return kaznasByKId;
    }

    public void setKaznasByKId(Collection<Kazna> kaznasByKId) {
        this.kaznasByKId = kaznasByKId;
    }

    @OneToMany(mappedBy = "korisnikByPatnikKId")
    public Collection<Kaznazaregistriran> getKaznazaregistriransByKId() {
        return kaznazaregistriransByKId;
    }

    public void setKaznazaregistriransByKId(Collection<Kaznazaregistriran> kaznazaregistriransByKId) {
        this.kaznazaregistriransByKId = kaznazaregistriransByKId;
    }
}
