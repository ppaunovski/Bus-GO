package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.*;
import mk.ukim.finki.busngo.model.exceptions.UserShouldNotBeTicketedException;
import mk.ukim.finki.busngo.repository.KaznaZaRegistriranRepository;
import mk.ukim.finki.busngo.service.KaznaZaRegistriranService;
import mk.ukim.finki.busngo.service.KondukterService;
import mk.ukim.finki.busngo.service.KontrolaService;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KaznaZaRegistriranServiceImpl implements KaznaZaRegistriranService {
    private final PatnikService patnikService;
    private final KaznaZaRegistriranRepository kaznaZaRegistriranRepository;
    private final KontrolaService kontrolaService;
    private final KondukterService kondukterService;

    public KaznaZaRegistriranServiceImpl(PatnikService patnikService, KaznaZaRegistriranRepository kaznaZaRegistriranRepository, KontrolaService kontrolaService, KondukterService kondukterService) {
        this.patnikService = patnikService;
        this.kaznaZaRegistriranRepository = kaznaZaRegistriranRepository;
        this.kontrolaService = kontrolaService;
        this.kondukterService = kondukterService;
    }

    @Override
    public List<Kaznazaregistriran> findAllByPatnik(String email) {
        Patnik patnik = patnikService.loadUserByEmail(email);
        return kaznaZaRegistriranRepository.findAllByKorisnikByPatnikKId(patnik);
    }

    @Override
    public Kaznazaregistriran create(Long kontrolaId, String dokument, Double iznos, Long patnik, String email) {
        Kontroli kontroli = kontrolaService.findById(kontrolaId);
        Kondukter kondukter = kondukterService.findByEmail(email);
        Patnik patnik1 = patnikService.findById(patnik);
        Kaznazaregistriran kaznazaregistriran = new Kaznazaregistriran();
        kaznazaregistriran.setKzDatum(Timestamp.valueOf(LocalDateTime.now()));
        kaznazaregistriran.setKzDokument(dokument);
        kaznazaregistriran.setKzIznos(iznos);
        kaznazaregistriran.setKzPlateno(false);
        kaznazaregistriran.setKontroliByKontrolaId(kontroli);
        kaznazaregistriran.setKorisnikByPatnikKId(patnik1);
        kaznazaregistriran.setKorisnikByKondukterKId(kondukter);
        List<Vozenje> vozenjeList = patnik1.getVozenjesByKId().stream()
                .filter(v -> v.getInstancanalinijaByInlId().getInlId().equals(kontroli.getInstancanalinijaByInlId().getInlId()))
                .toList();
        if(vozenjeList.isEmpty())
            return kaznaZaRegistriranRepository.save(kaznazaregistriran);

        throw new UserShouldNotBeTicketedException(String.format("Patnik with id: %d and email: %s has valid vozenje for the %d instance!",
                patnik1.getKId(),
                patnik1.getKEmail(),
                kontroli.getInstancanalinijaByInlId().getInlId()));
    }

    @Override
    public Kaznazaregistriran pay(Long kaznaId) {
        Kaznazaregistriran kazna = this.findById(kaznaId);
        if(!kazna.getKzPlateno()){
            kazna.setKzPlateno(true);
            kazna.setKzDatumPlateno(Timestamp.valueOf(LocalDateTime.now()));
        }
        return kaznaZaRegistriranRepository.save(kazna);
    }

    @Override
    public Kaznazaregistriran findById(Long id) {
        return kaznaZaRegistriranRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
