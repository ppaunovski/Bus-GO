package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Vozenje;
import mk.ukim.finki.busngo.model.enums.VOZENJE_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VozenjeRepository extends JpaRepository<Vozenje, Long> {
    List<Vozenje> findAllByKorisnikByPatnikKId(Patnik patnik);
    List<Vozenje> findAllByKorisnikByPatnikKIdAndAndVozenjeStatus(Patnik patnik, VOZENJE_STATUS vozenjeStatus);
}
