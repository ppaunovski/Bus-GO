package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Linija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinijaRepository extends JpaRepository<Linija, Long> {
}
