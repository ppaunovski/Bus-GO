package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Instancanalinija;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.exceptions.InvalidPatnikIdException;
import mk.ukim.finki.busngo.repository.PatnikRepository;
import mk.ukim.finki.busngo.service.InstancaNaLinijaService;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PatnikServiceImpl implements PatnikService {
    private final PatnikRepository patnikRepository;
    private final InstancaNaLinijaService instancaNaLinijaService;

    public PatnikServiceImpl(PatnikRepository patnikRepository, InstancaNaLinijaService instancaNaLinijaService) {
        this.patnikRepository = patnikRepository;
        this.instancaNaLinijaService = instancaNaLinijaService;
    }

    @Override
    public List<Patnik> listAll() {
        return  patnikRepository.findAll();
    }

    @Override
    public Patnik findById(Long id) {
        return patnikRepository.findById(id).orElseThrow(InvalidPatnikIdException::new);
    }

    @Override
    public Patnik loadUserByEmail(String email) {
        return patnikRepository.findByKEmail(email).orElseThrow(InvalidPatnikIdException::new);
    }

    @Override
    public Patnik save(Korisnik korisnik) {
        Patnik patnik = new Patnik();
        patnik.setKId(korisnik.getKId());
        patnik.setKEmail(korisnik.getKEmail());
        patnik.setKAdresa(korisnik.getKAdresa());
        patnik.setKIme(korisnik.getKIme());
        patnik.setKTelefon(korisnik.getKTelefon());
        patnik.setKIsAdmin(korisnik.getKIsAdmin());
        patnik.setKLozinka(korisnik.getKLozinka());

        return patnikRepository.save((Patnik) korisnik);
    }


}
