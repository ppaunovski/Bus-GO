package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Kondukter extends Vraboten{
    @OneToMany(mappedBy = "korisnikByKondukterKId")
    private List<Kazna> kaznasByKId;
    @OneToMany(mappedBy = "korisnikByKondukterKId")
    private List<Kontroli> kontrolisByKId;

}
