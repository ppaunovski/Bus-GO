package mk.ukim.finki.busngo.repository;

import mk.ukim.finki.busngo.model.entities.Instancanalinija;
import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.service.LinijaService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstancaNaLinijaRepository extends JpaRepository<Instancanalinija, Long> {
    List<Instancanalinija> findAllByLinijaByLiIdAndInlDatumEndIsNull(Linija linija);
    List<Instancanalinija> findAllByInlDatumEndIsNull();
}
