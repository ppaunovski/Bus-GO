package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.util.Objects;

@Data
@Entity
public class Vraboten extends Korisnik {
    @Basic
    @Column(name = "v_plata")
    private Double vPlata;

    @Basic
    @Column(name = "v_datum_na_vrabotuvanje")
    private Date vDatumNaVrabotuvanje;

    @Basic
    @Column(name = "v_datum_prekin_vrabotuvanje")
    private Date vDatumPrekinVrabotuvanje;

}
