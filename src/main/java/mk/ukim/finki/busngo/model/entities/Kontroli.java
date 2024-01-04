package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Kontroli {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kontrola_id")
    private Long kontrolaId;
    @Basic
    @Column(name = "kontrola_datum")
    private Timestamp kontrolaDatum;
    @OneToMany(mappedBy = "kontroliByKontrolaId")
    private List<Kazna> kaznasByKontrolaId;
    @ManyToOne
    @JoinColumn(name = "kondukter_k_id", referencedColumnName = "k_id")
    private Korisnik korisnikByKondukterKId;
    @ManyToOne
    @JoinColumn(name = "inl_id", referencedColumnName = "inl_id")
    private Instancanalinija instancanalinijaByInlId;

}
