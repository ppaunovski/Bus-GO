package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Avtobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AvtobusRepository extends JpaRepository<Avtobus, Long> {
    @Query("select a from Avtobus a where a.aRegistracija = ?1")
    Optional<Avtobus> findByARegistracija(String registracija);
}
