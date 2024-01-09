package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Bilet;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Tipbilet;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import mk.ukim.finki.busngo.model.exceptions.InvalidBiletIdException;
import mk.ukim.finki.busngo.model.exceptions.InvalidTipBiletIdException;
import mk.ukim.finki.busngo.repository.BiletRepository;
import mk.ukim.finki.busngo.repository.KorisnikRepository;
import mk.ukim.finki.busngo.repository.TipBIletRepository;
import mk.ukim.finki.busngo.service.BiletService;
import mk.ukim.finki.busngo.service.KorisnikService;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final KorisnikRepository korisnikRepository;

    public BiletServiceImpl(BiletRepository biletRepository, KorisnikService korisnikService, TipBIletRepository tipBIletRepository, PatnikService patnikService, PasswordEncoder passwordEncoder, KorisnikRepository korisnikRepository) {
        this.biletRepository = biletRepository;
        this.korisnikService = korisnikService;
        this.tipBIletRepository = tipBIletRepository;
        this.patnikService = patnikService;
        this.passwordEncoder = passwordEncoder;
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Bilet> listAll() {
        return biletRepository.findAll();
    }

    @Override
    public List<Bilet> findAllByPatnikId(Long id) {
        Patnik patnik = patnikService.findById(id);
        return patnik.getBiletsByKId();
    }

    @Override
    public List<Bilet> findAllByPatnikIdAndStatus(Long id, BILET_STATUS status) {
        Korisnik korisnik = korisnikService.findById(id);
        return new ArrayList<>();
    }

    @Override
    public Bilet buy(Long tipbilet, LocalDateTime now, BILET_STATUS biletStatus, String name) {
        Tipbilet tipbilet1 = tipBIletRepository.findById(tipbilet).orElseThrow(InvalidTipBiletIdException::new);
        Patnik korisnik = patnikService.loadUserByEmail(name);
        Bilet bilet = new Bilet();
        bilet.setBStatus(biletStatus);
        bilet.setTipbiletByTbId(tipbilet1);
        bilet.setBDatumNaKupuvanje(Timestamp.valueOf(now));
        bilet.setKorisnikByPatnikKId(korisnik);
        return biletRepository.save(bilet);
    }

    @Override
    public List<Bilet> findAllByPatnikEmail(String email) {
        Patnik patnik = patnikService.loadUserByEmail(email);
        return patnik.getBiletsByKId();
    }

    @Override
    public Bilet findBybIdAndPatnikEmail(Long bId, String email) {
        Patnik patnik = patnikService.loadUserByEmail(email);
        return biletRepository.findByBIdAndAndKorisnikByPatnikKId(bId, patnik).orElseThrow(InvalidBiletIdException::new);
    }

    @Override
    public Bilet activate(Long bId) {
        Bilet bilet = this.findById(bId);
        bilet.setBStatus(BILET_STATUS.ACTIVE);
        return biletRepository.save(bilet);
    }

    @Override
    public Bilet findById(Long bId) {
        return biletRepository.findById(bId).orElseThrow(RuntimeException::new);
    }

    @Override
    public Bilet finish(Long bId) {
        Bilet bilet = this.findById(bId);
        bilet.setBStatus(BILET_STATUS.EXPIRED);
        return biletRepository.save(bilet);
    }

    @Override
    public boolean checkExpiration(Long bId) {
        Bilet bilet = this.findById(bId);
        LocalDateTime timeBought = bilet.getBDatumNaKupuvanje().toLocalDateTime();

        if(timeBought.plusSeconds(bilet.getTipbiletByTbId().getTbTrajnost()).isBefore(LocalDateTime.now())){
            bilet.setBStatus(BILET_STATUS.EXPIRED);
            biletRepository.save(bilet);
            return true;
        }

        return false;
    }

//    @Override
//    public void encode(){
//        List<Korisnik> all = korisnikRepository.findAll();
//        all.forEach(p -> p.setKLozinka(passwordEncoder.encode(p.getKLozinka())));
//        korisnikRepository.saveAll(all);
//        System.out.println("DONE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//    }


}
