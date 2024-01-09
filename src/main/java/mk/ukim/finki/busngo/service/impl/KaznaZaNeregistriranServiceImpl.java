package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Kaznazaneregistriran;
import mk.ukim.finki.busngo.model.entities.Kondukter;
import mk.ukim.finki.busngo.model.entities.Kontroli;
import mk.ukim.finki.busngo.repository.KaznaZaNeregistriranRepository;
import mk.ukim.finki.busngo.service.KaznaZaNeregistriranService;
import mk.ukim.finki.busngo.service.KondukterService;
import mk.ukim.finki.busngo.service.KontrolaService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class KaznaZaNeregistriranServiceImpl implements KaznaZaNeregistriranService {
    private final KaznaZaNeregistriranRepository kaznaZaNeregistriranRepository;
    private final KontrolaService kontrolaService;
    private final KondukterService kondukterService;

    public KaznaZaNeregistriranServiceImpl(KaznaZaNeregistriranRepository kaznaZaNeregistriranRepository, KontrolaService kontrolaService, KondukterService kondukterService) {
        this.kaznaZaNeregistriranRepository = kaznaZaNeregistriranRepository;
        this.kontrolaService = kontrolaService;
        this.kondukterService = kondukterService;
    }

    @Override
    public List<Kaznazaneregistriran> findAll() {
        return kaznaZaNeregistriranRepository.findAll();
    }

    @Override
    public Kaznazaneregistriran findById(Long id) {
        return kaznaZaNeregistriranRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Kaznazaneregistriran create(Long kontrolaId, String dokument, Double iznos, String telefon, String ime, String adresa, String email) {
        Kondukter byEmail = kondukterService.findByEmail(email);
        Kontroli kontroli = kontrolaService.findById(kontrolaId);
        Kaznazaneregistriran kaznazaneregistriran = new Kaznazaneregistriran();
        kaznazaneregistriran.setKznAdresa(adresa);
        kaznazaneregistriran.setKznIme(ime);
        kaznazaneregistriran.setKznTelefon(telefon);
        kaznazaneregistriran.setKzDatum(Timestamp.valueOf(LocalDateTime.now()));
        kaznazaneregistriran.setKontroliByKontrolaId(kontroli);
        kaznazaneregistriran.setKorisnikByKondukterKId(byEmail);
        kaznazaneregistriran.setKzIznos(iznos);
        kaznazaneregistriran.setKzDokument(dokument);
        kaznazaneregistriran.setKzPlateno(false);
        return kaznaZaNeregistriranRepository.save(kaznazaneregistriran);
    }
}
