package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.*;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import mk.ukim.finki.busngo.model.enums.VOZENJE_STATUS;
import mk.ukim.finki.busngo.model.exceptions.InvalidVozenjeIdException;
import mk.ukim.finki.busngo.repository.VozenjeRepository;
import mk.ukim.finki.busngo.service.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VozenjeServiceImpl  implements VozenjeService {
    private final VozenjeRepository vozenjeRepository;
    private final PatnikService patnikService;
    private final BiletService biletService;
    private final PostojkaNaLinijaService postojkaNaLinijaService;
    private final InstancaNaLinijaService instancaNaLinijaService;

    public VozenjeServiceImpl(VozenjeRepository vozenjeRepository, PatnikService patnikService, BiletService biletService, PostojkaNaLinijaService postojkaNaLinijaService, InstancaNaLinijaService instancaNaLinijaService) {
        this.vozenjeRepository = vozenjeRepository;
        this.patnikService = patnikService;
        this.biletService = biletService;
        this.postojkaNaLinijaService = postojkaNaLinijaService;
        this.instancaNaLinijaService = instancaNaLinijaService;
    }

    @Override
    public List<Vozenje> findVozenjaByPatnik(String email) {
        Patnik patnik = patnikService.loadUserByEmail(email);
        return vozenjeRepository.findAllByKorisnikByPatnikKId(patnik);
    }

    @Override
    public Vozenje start(String email, Long bId, Long pnlId, Long inlId) {
        Patnik patnik = patnikService.loadUserByEmail(email);
        Bilet bilet = biletService.findBybIdAndPatnikEmail(bId, email);
        Postojkanalinija postojkanalinija = postojkaNaLinijaService.findById(pnlId);
        Instancanalinija instancanalinija = instancaNaLinijaService.findById(inlId);

        Vozenje vozenje = new Vozenje();
        vozenje.setVozenjeStart(Timestamp.valueOf(LocalDateTime.now()));
        vozenje.setVozenjeStatus(VOZENJE_STATUS.ACTIVE);
        vozenje.setInstancanalinijaByInlId(instancanalinija);
        vozenje.setKorisnikByPatnikKId(patnik);
        vozenje.setPostojkanalinijaByKacuvaPnlId(postojkanalinija);

        if(bilet.getBStatus().equals(BILET_STATUS.INACTIVE))
            bilet = biletService.activate(bId);
        else if(biletService.checkExpiration(bId))
            throw new RuntimeException("Bilet is expired!");
        else if(bilet.getBStatus().equals(BILET_STATUS.EXPIRED))
            throw new RuntimeException("Bilet is expired!");

        vozenje.setBiletByBId(bilet);
        return vozenjeRepository.save(vozenje);
    }

    @Override
    public Vozenje end(Long vozenjeId, Long pnlId) {
        // TODO : Relacija se simnuva na pnlId
        Vozenje vozenje = this.findById(vozenjeId);
        vozenje.setVozenjeEnd(Timestamp.valueOf(LocalDateTime.now()));
        vozenje.setVozenjeStatus(VOZENJE_STATUS.FINISHED);
        return vozenjeRepository.save(vozenje);
    }

    @Override
    public Vozenje findById(Long id) {
        return vozenjeRepository.findById(id).orElseThrow(InvalidVozenjeIdException::new);
    }
}
