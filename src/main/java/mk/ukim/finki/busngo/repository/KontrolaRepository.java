package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Instancanalinija;
import mk.ukim.finki.busngo.model.entities.Kontroli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KontrolaRepository extends JpaRepository<Kontroli, Long> {
    List<Kontroli> findAllByInstancanalinijaByInlId(Instancanalinija inl);
}
