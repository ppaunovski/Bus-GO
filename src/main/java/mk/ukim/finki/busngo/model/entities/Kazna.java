package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Kazna {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kz_id")
    private Long kzId;

    @Basic
    @Column(name = "kz_iznos")
    private Double kzIznos;

    @Basic
    @Column(name = "kz_plateno")
    private Boolean kzPlateno;

    @Basic
    @Column(name = "kz_datum")
    private Timestamp kzDatum;

    @Basic
    @Column(name = "kz_datum_plateno")
    private Timestamp kzDatumPlateno;

    @Basic
    @Column(name = "kz_dokument")
    private String kzDokument;

    @ManyToOne
    @JoinColumn(name = "kondukter_k_id", referencedColumnName = "k_id")
    private Kondukter korisnikByKondukterKId;

    @ManyToOne
    @JoinColumn(name = "kontrola_id", referencedColumnName = "kontrola_id")
    private Kontroli kontroliByKontrolaId;

//    @OneToOne(mappedBy = "kaznaByKzId")
//    private Kaznazaneregistriran kaznazaneregistriranByKzId;
//
//    @OneToOne(mappedBy = "kaznaByKzId")
//    private Kaznazaregistriran kaznazaregistriranByKzId;
}
