package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.*;
import mk.ukim.finki.busngo.model.exceptions.InvalidInstancaNaLinijaIdException;
import mk.ukim.finki.busngo.repository.InstancaNaLinijaRepository;
import mk.ukim.finki.busngo.service.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstancaNaLinijaServiceImpl implements InstancaNaLinijaService{
    private final InstancaNaLinijaRepository instancaNaLinijaRepository;
    private final VozacService vozacService;
    private final AvtobusService avtobusService;
    private final LinijaService linijaService;
    private final PostojkaNaLinijaService postojkaNaLinijaService;

    public InstancaNaLinijaServiceImpl(InstancaNaLinijaRepository instancaNaLinijaRepository, VozacService vozacService, AvtobusService avtobusService, LinijaService linijaService, PostojkaNaLinijaService postojkaNaLinijaService) {
        this.instancaNaLinijaRepository = instancaNaLinijaRepository;
        this.vozacService = vozacService;
        this.avtobusService = avtobusService;
        this.linijaService = linijaService;
        this.postojkaNaLinijaService = postojkaNaLinijaService;
    }

    @Override
    public List<Instancanalinija> findAll() {
        return instancaNaLinijaRepository.findAll();
    }

    @Override
    public Instancanalinija findById(Long inlId) {
        return instancaNaLinijaRepository.findById(inlId).orElseThrow(InvalidInstancaNaLinijaIdException::new);
    }

    @Override
    public Instancanalinija start(Long liId, String a_registracija, String email) {
        Linija linija = linijaService.findById(liId);
        Avtobus avtobus = avtobusService.findById(a_registracija);
        Vozac vozac = vozacService.findByEmail(email);
        Instancanalinija instancanalinija = new Instancanalinija();
        instancanalinija.setLinijaByLiId(linija);
        instancanalinija.setAvtobusByARegistracija(avtobus);
        instancanalinija.setKorisnikByVozacKId(vozac);
        instancanalinija.setInlDatumStart(Timestamp.valueOf(LocalDateTime.now()));

        return instancaNaLinijaRepository.save(instancanalinija);
    }

    @Override
    public Instancanalinija end(Long inlId) {
        Instancanalinija instancanalinija = this.findById(inlId);
        instancanalinija.setInlDatumEnd(Timestamp.valueOf(LocalDateTime.now()));
        return instancaNaLinijaRepository.save(instancanalinija);
    }

    @Override
    public List<Instancanalinija> findAllActive() {
        return instancaNaLinijaRepository.findAllByInlDatumEndIsNull();
    }

    @Override
    public List<Instancanalinija> findByPnlId(Long pnlId) {
        Postojkanalinija postojkanalinija = postojkaNaLinijaService.findById(pnlId);
        Linija linijaByLiId = postojkanalinija.getLinijaByLiId();
        return instancaNaLinijaRepository.findAllByLinijaByLiIdAndInlDatumEndIsNull(linijaByLiId);
    }
}
