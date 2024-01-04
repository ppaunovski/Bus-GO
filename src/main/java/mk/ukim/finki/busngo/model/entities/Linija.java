package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.invoke.CallSite;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Linija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "li_id")
    private Integer liId;
    @Basic
    @Column(name = "li_ime")
    private String liIme;
    @Basic
    @Column(name = "li_pravec")
    private String liPravec;
    @OneToMany(mappedBy = "linijaByLiId")
    private List<Instancanalinija> instancanalinijasByLiId;
    @OneToMany(mappedBy = "linijaByLiId")
    private List<Postojkanalinija> postojkanalinijasByLiId;

}
