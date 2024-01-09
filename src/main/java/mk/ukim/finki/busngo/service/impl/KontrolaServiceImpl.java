package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Instancanalinija;
import mk.ukim.finki.busngo.model.entities.Kondukter;
import mk.ukim.finki.busngo.model.entities.Kontroli;
import mk.ukim.finki.busngo.repository.KontrolaRepository;
import mk.ukim.finki.busngo.service.InstancaNaLinijaService;
import mk.ukim.finki.busngo.service.KondukterService;
import mk.ukim.finki.busngo.service.KontrolaService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KontrolaServiceImpl implements KontrolaService {
    private final KontrolaRepository kontrolaRepository;
    private final KondukterService kondukterService;
    private final InstancaNaLinijaService instancaNaLinijaService;

    public KontrolaServiceImpl(KontrolaRepository kontrolaRepository, KondukterService kondukterService, InstancaNaLinijaService instancaNaLinijaService) {
        this.kontrolaRepository = kontrolaRepository;
        this.kondukterService = kondukterService;
        this.instancaNaLinijaService = instancaNaLinijaService;
    }

    @Override
    public List<Kontroli> findAll() {
        return kontrolaRepository.findAll();
    }

    @Override
    public Kontroli create(Long inlId, String email) {
        Kondukter kondukter = kondukterService.findByEmail(email);
        Instancanalinija instancanalinija = instancaNaLinijaService.findById(inlId);
        Kontroli kontroli = new Kontroli();
        kontroli.setKontrolaDatum(Timestamp.valueOf(LocalDateTime.now()));
        kontroli.setKorisnikByKondukterKId(kondukter);
        kontroli.setInstancanalinijaByInlId(instancanalinija);

        return kontrolaRepository.save(kontroli);
    }

    @Override
    public Kontroli findById(Long kontrolaId) {
        return kontrolaRepository.findById(kontrolaId).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Kontroli> findAllByInl(Long inlId) {
        Instancanalinija instancanalinija = instancaNaLinijaService.findById(inlId);
        return kontrolaRepository.findAllByInstancanalinijaByInlId(instancanalinija);
    }
}
