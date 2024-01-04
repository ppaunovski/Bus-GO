package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Bilet;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BiletRepository extends JpaRepository<Bilet, Long> {
//    List<Bilet> findAllByKorisnikByPatnikKIdAndBStatus(Korisnik korisnik, BILET_STATUS status);
//    List<Bilet> findAllByKorisnikByPatnikKId(Korisnik korisnik);
}
