package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.exceptions.InvalidUserId;
import mk.ukim.finki.busngo.repository.KorisnikRepository;
import mk.ukim.finki.busngo.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {
    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }


    @Override
    public List<Korisnik> listAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(Long id) {
        return korisnikRepository.findById(id).orElseThrow(InvalidUserId::new);
    }

    @Override
    public Korisnik loadUserByEmail(String email) {
        return korisnikRepository.findByKEmail(email).orElseThrow(InvalidUserId::new);
    }
}
