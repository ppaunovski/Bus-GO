package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Kondukter;
import mk.ukim.finki.busngo.model.entities.Patnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KondukterRepository extends JpaRepository<Kondukter, Long> {
    @Query("SELECT p from Kondukter p where p.kEmail = ?1")
    Optional<Kondukter> findByKEmail(String email);
}
