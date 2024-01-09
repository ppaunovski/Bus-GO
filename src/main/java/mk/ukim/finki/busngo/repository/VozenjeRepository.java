package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Vozenje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VozenjeRepository extends JpaRepository<Vozenje, Long> {
    List<Vozenje> findAllByKorisnikByPatnikKId(Patnik patnik);
}
