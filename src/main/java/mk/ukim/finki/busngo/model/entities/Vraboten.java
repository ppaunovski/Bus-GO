package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.util.Objects;

@Data
@Entity
public class Vraboten {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "k_id")
    private Long kId;
    @Basic
    @Column(name = "v_plata")
    private Double vPlata;
    @Basic
    @Column(name = "v_datum_na_vrabotuvanje")
    private Date vDatumNaVrabotuvanje;
    @Basic
    @Column(name = "v_datum_prekin_vrabotuvanje")
    private Date vDatumPrekinVrabotuvanje;
    @OneToOne
    @JoinColumn(name = "k_id", referencedColumnName = "k_id", nullable = false)
    private Korisnik korisnikByKId;

}
