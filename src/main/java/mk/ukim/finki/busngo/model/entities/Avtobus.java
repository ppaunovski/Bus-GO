package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Avtobus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "a_registracija")
    private String aRegistracija;
    @Basic
    @Column(name = "a_seriski_broj")
    private String aSeriskiBroj;
    @Basic
    @Column(name = "a_broj_sedista")
    private Short aBrojSedista;
    @OneToMany(mappedBy = "avtobusByARegistracija")
    private List<Instancanalinija> instancanalinijaList;
}
