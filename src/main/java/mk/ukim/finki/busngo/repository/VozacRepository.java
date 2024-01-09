package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Vozac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VozacRepository extends JpaRepository<Vozac, Long> {

    @Query("SELECT v from Vozac v where v.kEmail = ?1")
    Optional<Vozac> findByKEmail(String email);
}
