package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.enums.VrabotenType;

public interface AuthService {
    Korisnik login(String email, String password);
    Korisnik registerPatnik(String ime, String email, String password, String confirmPassword, String address, String telefon);
    Korisnik registerVraboten(String ime, String email, String password, String confirmPassword, String address, String telefon, VrabotenType type, Double salary);

}
