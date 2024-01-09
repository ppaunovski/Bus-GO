package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Kazna;
import mk.ukim.finki.busngo.model.entities.Kontroli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


public interface KaznaRepository extends JpaRepository<Kazna, Long> {
    List<Kazna> findAllByKontroliByKontrolaId(Kontroli kontroli);
}
