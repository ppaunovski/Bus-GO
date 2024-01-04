package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Patnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PatnikRepository extends JpaRepository<Patnik, Long> {

}
