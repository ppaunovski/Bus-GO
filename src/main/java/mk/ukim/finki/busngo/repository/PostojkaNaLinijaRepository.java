package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.model.entities.Postojkanalinija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import java.util.List;
import java.util.Optional;

public interface PostojkaNaLinijaRepository extends JpaRepository<Postojkanalinija, Long> {
    List<Postojkanalinija> findAllByLinijaByLiId(Linija linija);
    List<Postojkanalinija> findAllByLinijaByLiIdAndPnlRedenBrojGreaterThan(Linija linija, Short redenBroj);
}
