package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Mesto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "m_id")
    private Integer mId;
    @Basic
    @Column(name = "m_grad")
    private String mGrad;
    @Basic
    @Column(name = "m_opstina")
    private String mOpstina;
    @Basic
    @Column(name = "m_ulica")
    private String mUlica;
    @OneToMany(mappedBy = "mestoByMId")
    private List<Postojka> postojkasByMId;
}
