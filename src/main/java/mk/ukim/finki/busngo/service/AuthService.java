package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Korisnik;

public interface AuthService {
    Korisnik login(String email, String password);
    Korisnik register(String ime, String email, String password, String confirmPassword, String address, String telefon);

}
