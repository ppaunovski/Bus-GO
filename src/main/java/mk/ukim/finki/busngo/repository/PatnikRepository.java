package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Patnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PatnikRepository extends JpaRepository<Patnik, Long> {
    @Query("SELECT p from Patnik p where p.kEmail = ?1")
    Optional<Patnik> findByKEmail(String email);
}
