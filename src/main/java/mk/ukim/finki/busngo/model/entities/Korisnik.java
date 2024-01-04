package mk.ukim.finki.busngo.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.busngo.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Korisnik implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "k_id")
    private Long kId;
    @Basic
    @Column(name = "k_ime")
    private String kIme;
    @Basic
    @Column(name = "k_adresa")
    private String kAdresa;
    @Basic
    @Column(name = "k_telefon")
    private String kTelefon;
    @Basic
    @Column(name = "k_email")
    private String kEmail;
    @Basic
    @Column(name = "k_embg")
    private String kEmbg;
    @Basic
    @Column(name = "k_is_admin")
    private Boolean kIsAdmin;
    @Basic
    @Column(name = "k_lozinka")
    private String kLozinka;
    @OneToMany(mappedBy = "korisnikByPatnikKId")
    private List<Bilet> biletsByKId;
//    private boolean isAccountNonExpired = true;
//    private boolean isAccountNonLocked = true;
//    private boolean isCredentialsNonExpired =  true;
//    private boolean isEnabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return kIsAdmin ? Collections.singletonList(Role.ROLE_ADMIN) : Collections.singletonList(Role.ROLE_USER);
    }

    @Override
    public String getPassword() {
        return kLozinka;
    }

    @Override
    public String getUsername() {
        return kEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


//    @OneToMany(mappedBy = "korisnikByVozacKId")
//    private List<Instancanalinija> instancanalinijasByKId;
//    @OneToMany(mappedBy = "korisnikByKondukterKId")
//    private List<Kazna> kaznasByKId;
//    @OneToMany(mappedBy = "korisnikByPatnikKId")
//    private List<Kaznazaregistriran> kaznazaregistriransByKId;
//    @OneToOne(mappedBy = "korisnikByKId")
//    private Kondukter kondukterByKId;
//    @OneToMany(mappedBy = "korisnikByKondukterKId")
//    private List<Kontroli> kontrolisByKId;
//    @OneToOne(mappedBy = "korisnikByKId")
//    private Patnik patnikByKId;
//    @OneToOne(mappedBy = "korisnikByKId")
//    private Vozac vozacByKId;
//    @OneToMany(mappedBy = "korisnikByPatnikKId")
//    private List<Vozenje> vozenjesByKId;
//    @OneToOne(mappedBy = "korisnikByKId")
//    private Vraboten vrabotenByKId;
}
