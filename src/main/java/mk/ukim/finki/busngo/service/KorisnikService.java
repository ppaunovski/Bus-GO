package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.enums.Role;


import java.util.List;

public interface KorisnikService {
    List<Korisnik> listAll();
    Korisnik findById(Long id);
    Korisnik loadUserByEmail(String email);

}
