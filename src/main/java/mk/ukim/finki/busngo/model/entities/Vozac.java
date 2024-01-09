package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Vozac extends Vraboten {
    @OneToMany(mappedBy = "korisnikByVozacKId")
    private List<Instancanalinija> instancanalinijasByKId;

}
