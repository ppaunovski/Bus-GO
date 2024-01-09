package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Kaznazaneregistriran extends Kazna {
    @Basic
    @Column(name = "kzn_telefon")
    private String kznTelefon;

    @Basic
    @Column(name = "kzn_ime")
    private String kznIme;

    @Basic
    @Column(name = "kzn_adresa")
    private String kznAdresa;
}
