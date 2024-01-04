package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Tipbilet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tb_id", columnDefinition = "serial")
    private Long tbId;
    @Basic
    @Column(name = "tb_trajnost")
    private Long tbTrajnost;
    @Basic
    @Column(name = "tb_ime")
    private String tbIme;
    @OneToMany(mappedBy = "tipbiletByTbId")
    private List<Bilet> biletsByTbId;


}
