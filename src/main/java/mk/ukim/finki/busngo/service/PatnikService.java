package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Bilet;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Patnik;

import java.util.List;

public interface PatnikService {
    List<Patnik> listAll();
    Patnik findById(Long id);
    Patnik loadUserByEmail(String email);

    Patnik save(Korisnik korisnik);

}
