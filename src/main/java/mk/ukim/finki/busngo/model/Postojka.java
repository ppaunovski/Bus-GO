package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Postojka {
    private Integer pId;
    private String pIme;
    private Integer mId;
    private Mesto mestoByMId;
    private List<Postojkanalinija> postojkanalinijasByPId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "p_ime", nullable = false)
    public String getpIme() {
        return pIme;
    }

    public void setpIme(String pIme) {
        this.pIme = pIme;
    }

    @Basic
    @Column(name = "m_id", nullable = true)
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postojka postojka = (Postojka) o;
        return Objects.equals(pId, postojka.pId) && Objects.equals(pIme, postojka.pIme) && Objects.equals(mId, postojka.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, pIme, mId);
    }

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    public Mesto getMestoByMId() {
        return mestoByMId;
    }

    public void setMestoByMId(Mesto mestoByMId) {
        this.mestoByMId = mestoByMId;
    }

    @OneToMany(mappedBy = "postojkaByPId")
    public List<Postojkanalinija> getPostojkanalinijasByPId() {
        return postojkanalinijasByPId;
    }

    public void setPostojkanalinijasByPId(List<Postojkanalinija> postojkanalinijasByPId) {
        this.postojkanalinijasByPId = postojkanalinijasByPId;
    }
}
