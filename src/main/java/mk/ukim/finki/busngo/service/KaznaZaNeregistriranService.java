package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Kaznazaneregistriran;
import mk.ukim.finki.busngo.model.entities.Kaznazaregistriran;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface KaznaZaNeregistriranService {
    List<Kaznazaneregistriran> findAll();
    Kaznazaneregistriran findById(Long id);
    Kaznazaneregistriran create(Long kontrolaId,
                                 String dokument,
                                Double iznos,
                                 String telefon,
                                 String ime,
                                 String adresa,
                                String email);
}
