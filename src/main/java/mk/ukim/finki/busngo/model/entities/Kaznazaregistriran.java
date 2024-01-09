package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Kaznazaregistriran extends Kazna{
    @ManyToOne
    @JoinColumn(name = "patnik_k_id", referencedColumnName = "k_id")
    private Patnik korisnikByPatnikKId;
}
