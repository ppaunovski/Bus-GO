package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Vozac {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "k_id")
    private Long kId;
    @OneToOne
    @JoinColumn(name = "k_id", referencedColumnName = "k_id", nullable = false)
    private Korisnik korisnikByKId;

}
