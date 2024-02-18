package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Instancanalinija;

import javax.swing.event.ListDataEvent;
import java.time.LocalDateTime;
import java.util.List;

public interface InstancaNaLinijaService {
    List<Instancanalinija> findAll();
    Instancanalinija findById(Long inlId);
    Instancanalinija start(Long liId, String a_registracija, String email);
    Instancanalinija end(Long inlId, String email);
    List<Instancanalinija> findAllActive();

    List<Instancanalinija> findByPnlId(Long pnlId);
}
