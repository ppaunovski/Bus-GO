package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Vozac extends Vraboten {
    @OneToMany(mappedBy = "korisnikByVozacKId")
    private List<Instancanalinija> instancanalinijasByKId;

}
