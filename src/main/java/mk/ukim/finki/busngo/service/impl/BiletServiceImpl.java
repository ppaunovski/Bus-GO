package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Bilet;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Tipbilet;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import mk.ukim.finki.busngo.model.exceptions.InvalidTipBiletIdException;
import mk.ukim.finki.busngo.repository.BiletRepository;
import mk.ukim.finki.busngo.repository.TipBIletRepository;
import mk.ukim.finki.busngo.service.BiletService;
import mk.ukim.finki.busngo.service.KorisnikService;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BiletServiceImpl implements BiletService {
    private final BiletRepository biletRepository;
    private final KorisnikService korisnikService;
    private final TipBIletRepository tipBIletRepository;
    private final PatnikService patnikService;

    public BiletServiceImpl(BiletRepository biletRepository, KorisnikService korisnikService, TipBIletRepository tipBIletRepository, PatnikService patnikService) {
        this.biletRepository = biletRepository;
        this.korisnikService = korisnikService;
        this.tipBIletRepository = tipBIletRepository;
        this.patnikService = patnikService;
    }

    @Override
    public List<Bilet> listAll() {
        return biletRepository.findAll();
    }

    @Override
    public List<Bilet> findAllByPatnikId(Long id) {
        Korisnik korisnik = korisnikService.findById(id);
        return new ArrayList<>();
    }

    @Override
    public List<Bilet> findAllByPatnikIdAndStatus(Long id, BILET_STATUS status) {
        Korisnik korisnik = korisnikService.findById(id);
        return new ArrayList<>();
    }

    @Override
    public Bilet buy(Long tipbilet, LocalDateTime now, BILET_STATUS biletStatus, String name) {
        Tipbilet tipbilet1 = tipBIletRepository.findById(tipbilet).orElseThrow(InvalidTipBiletIdException::new);
        Korisnik korisnik = korisnikService.loadUserByEmail(name);
        Bilet bilet = new Bilet();
        bilet.setBStatus(biletStatus);
        bilet.setTipbiletByTbId(tipbilet1);
        bilet.setBDatumNaKupuvanje(Timestamp.valueOf(now));
        bilet.setKorisnikByPatnikKId(korisnik);
        return biletRepository.save(bilet);
    }
}
