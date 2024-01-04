package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Kaznazaneregistriran {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kz_id")
    private Long kzId;
    @Basic
    @Column(name = "kzn_telefon")
    private String kznTelefon;
    @Basic
    @Column(name = "kzn_ime")
    private String kznIme;
    @Basic
    @Column(name = "kzn_adresa")
    private String kznAdresa;
    @OneToOne
    @JoinColumn(name = "kz_id", referencedColumnName = "kz_id", nullable = false)
    private Kazna kaznaByKzId;
}
