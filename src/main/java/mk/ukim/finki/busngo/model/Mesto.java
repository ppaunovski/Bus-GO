package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Mesto {
    private Integer mId;
    private String mGrad;
    private String mOpstina;
    private String mUlica;
    private List<Postojka> postojkasByMId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "m_id", nullable = false)
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "m_grad", nullable = false)
    public String getmGrad() {
        return mGrad;
    }

    public void setmGrad(String mGrad) {
        this.mGrad = mGrad;
    }

    @Basic
    @Column(name = "m_opstina", nullable = false)
    public String getmOpstina() {
        return mOpstina;
    }

    public void setmOpstina(String mOpstina) {
        this.mOpstina = mOpstina;
    }

    @Basic
    @Column(name = "m_ulica", nullable = false)
    public String getmUlica() {
        return mUlica;
    }

    public void setmUlica(String mUlica) {
        this.mUlica = mUlica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesto mesto = (Mesto) o;
        return Objects.equals(mId, mesto.mId) && Objects.equals(mGrad, mesto.mGrad) && Objects.equals(mOpstina, mesto.mOpstina) && Objects.equals(mUlica, mesto.mUlica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mGrad, mOpstina, mUlica);
    }

    @OneToMany(mappedBy = "mestoByMId")
    public List<Postojka> getPostojkasByMId() {
        return postojkasByMId;
    }

    public void setPostojkasByMId(List<Postojka> postojkasByMId) {
        this.postojkasByMId = postojkasByMId;
    }
}
