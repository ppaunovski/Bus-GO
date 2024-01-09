package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Kaznazaregistriran;
import mk.ukim.finki.busngo.model.entities.Patnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KaznaZaRegistriranRepository extends JpaRepository<Kaznazaregistriran, Long> {
    List<Kaznazaregistriran> findAllByKorisnikByPatnikKId(Patnik patnik);
}
