package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Postojka {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "p_id")
    private Integer pId;
    @Basic
    @Column(name = "p_ime")
    private String pIme;
    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    private Mesto mestoByMId;
    @OneToMany(mappedBy = "postojkaByPId")
    private List<Postojkanalinija> postojkanalinijasByPId;

}
