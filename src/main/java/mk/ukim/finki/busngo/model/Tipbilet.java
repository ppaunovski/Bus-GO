package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Tipbilet {
    private Integer tbId;
    private Long tbTrajnost;
    private String tbIme;
    private Collection<Bilet> biletsByTbId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tb_id", nullable = false)
    public Integer getTbId() {
        return tbId;
    }

    public void setTbId(Integer tbId) {
        this.tbId = tbId;
    }

    @Basic
    @Column(name = "tb_trajnost", nullable = false)
    public Long getTbTrajnost() {
        return tbTrajnost;
    }

    public void setTbTrajnost(Long tbTrajnost) {
        this.tbTrajnost = tbTrajnost;
    }

    @Basic
    @Column(name = "tb_ime", nullable = false)
    public String getTbIme() {
        return tbIme;
    }

    public void setTbIme(String tbIme) {
        this.tbIme = tbIme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipbilet tipbilet = (Tipbilet) o;
        return Objects.equals(tbId, tipbilet.tbId) && Objects.equals(tbTrajnost, tipbilet.tbTrajnost) && Objects.equals(tbIme, tipbilet.tbIme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tbId, tbTrajnost, tbIme);
    }

    @OneToMany(mappedBy = "tipbiletByTbId")
    public Collection<Bilet> getBiletsByTbId() {
        return biletsByTbId;
    }

    public void setBiletsByTbId(Collection<Bilet> biletsByTbId) {
        this.biletsByTbId = biletsByTbId;
    }
}
