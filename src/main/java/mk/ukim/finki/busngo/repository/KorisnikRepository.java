package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    @Query("SELECT k FROM Korisnik k WHERE k.kEmail = ?1 and k.kLozinka = ?2")
    Optional<Korisnik> findByKEmailAndKLozinka(String kEmail, String kLozinka);
    @Query("SELECT k FROM Korisnik k WHERE k.kEmail = ?1")
    Optional<Korisnik> findByKEmail(String kEmail);
}
