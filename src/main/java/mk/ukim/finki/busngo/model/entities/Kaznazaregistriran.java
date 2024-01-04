package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Kaznazaregistriran {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kz_id")
    private Long kzId;
    @OneToOne
    @JoinColumn(name = "kz_id", referencedColumnName = "kz_id", nullable = false)
    private Kazna kaznaByKzId;
    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    private Korisnik korisnikByPatnikKId;
}
