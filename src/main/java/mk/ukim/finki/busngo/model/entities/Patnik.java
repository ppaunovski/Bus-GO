package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Patnik extends Korisnik {
    @OneToMany(mappedBy = "korisnikByPatnikKId")
    private List<Bilet> biletsByKId;

    @OneToMany(mappedBy = "korisnikByPatnikKId")
    private List<Kaznazaregistriran> kaznazaregistriransByKId;

    @OneToMany(mappedBy = "korisnikByPatnikKId")
    private List<Vozenje> vozenjesByKId;
}
