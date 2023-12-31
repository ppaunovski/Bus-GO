package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Linija {
    private Integer liId;
    private String liIme;
    private String liPravec;
    private List<Postojkanalinija> postojkanalinijasByLiId;
    private List<Instancanalinija> instancanalinijasByLiId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "li_id", nullable = false)
    public Integer getLiId() {
        return liId;
    }

    public void setLiId(Integer liId) {
        this.liId = liId;
    }

    @Basic
    @Column(name = "li_ime", nullable = false)
    public String getLiIme() {
        return liIme;
    }

    public void setLiIme(String liIme) {
        this.liIme = liIme;
    }

    @Basic
    @Column(name = "li_pravec", nullable = false)
    public String getLiPravec() {
        return liPravec;
    }

    public void setLiPravec(String liPravec) {
        this.liPravec = liPravec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linija linija = (Linija) o;
        return Objects.equals(liId, linija.liId) && Objects.equals(liIme, linija.liIme) && Objects.equals(liPravec, linija.liPravec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liId, liIme, liPravec);
    }

    @OneToMany(mappedBy = "linijaByLiId")
    public List<Postojkanalinija> getPostojkanalinijasByLiId() {
        return postojkanalinijasByLiId;
    }

    public void setPostojkanalinijasByLiId(List<Postojkanalinija> postojkanalinijasByLiId) {
        this.postojkanalinijasByLiId = postojkanalinijasByLiId;
    }

    @OneToMany(mappedBy = "linijaByLiId")
    public List<Instancanalinija> getInstancanalinijasByLiId() {
        return instancanalinijasByLiId;
    }

    public void setInstancanalinijasByLiId(List<Instancanalinija> instancanalinijasByLiId) {
        this.instancanalinijasByLiId = instancanalinijasByLiId;
    }
}
