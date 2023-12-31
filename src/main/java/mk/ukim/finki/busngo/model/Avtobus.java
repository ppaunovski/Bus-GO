package mk.ukim.finki.busngo.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Avtobus {
    private String aRegistracija;
    private String aSeriskiBroj;
    private Short aBrojSedista;
    private Collection<Instancanalinija> instancanalinijasByARegistracija;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "a_registracija", nullable = false, length = 8)
    public String getaRegistracija() {
        return aRegistracija;
    }

    public void setaRegistracija(String aRegistracija) {
        this.aRegistracija = aRegistracija;
    }

    @Basic
    @Column(name = "a_seriski_broj", nullable = false)
    public String getaSeriskiBroj() {
        return aSeriskiBroj;
    }

    public void setaSeriskiBroj(String aSeriskiBroj) {
        this.aSeriskiBroj = aSeriskiBroj;
    }

    @Basic
    @Column(name = "a_broj_sedista", nullable = true)
    public Short getaBrojSedista() {
        return aBrojSedista;
    }

    public void setaBrojSedista(Short aBrojSedista) {
        this.aBrojSedista = aBrojSedista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avtobus avtobus = (Avtobus) o;
        return Objects.equals(aRegistracija, avtobus.aRegistracija) && Objects.equals(aSeriskiBroj, avtobus.aSeriskiBroj) && Objects.equals(aBrojSedista, avtobus.aBrojSedista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aRegistracija, aSeriskiBroj, aBrojSedista);
    }

    @OneToMany(mappedBy = "avtobusByARegistracija")
    public Collection<Instancanalinija> getInstancanalinijasByARegistracija() {
        return instancanalinijasByARegistracija;
    }

    public void setInstancanalinijasByARegistracija(Collection<Instancanalinija> instancanalinijasByARegistracija) {
        this.instancanalinijasByARegistracija = instancanalinijasByARegistracija;
    }
}
