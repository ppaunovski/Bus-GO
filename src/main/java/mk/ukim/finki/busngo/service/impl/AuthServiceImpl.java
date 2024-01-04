package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.busngo.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.busngo.repository.KorisnikRepository;
import mk.ukim.finki.busngo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Korisnik login(String email, String password) {
        if(email == null || password == null || email.isEmpty() || password.isEmpty())
            throw new InvalidCredentialsException();
        return korisnikRepository.findByKEmailAndKLozinka(email, password).orElseThrow(InvalidCredentialsException::new);
    }

    @Override
    public Korisnik register(String ime, String email, String password, String confirmPassword, String address, String telefon) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        if (!password.equals(confirmPassword)) {
            throw new InvalidCredentialsException();
        }

        if(this.korisnikRepository.findByKEmail(email).isPresent()) {
            throw new UserAlreadyExistsException(email);
        }

        Korisnik korisnik = new Korisnik();
        korisnik.setKIme(ime);
        korisnik.setKAdresa(address);
        korisnik.setKLozinka(passwordEncoder.encode(password));
        korisnik.setKEmail(email);
        korisnik.setKTelefon(telefon);
        korisnik.setKIsAdmin(false);

        return korisnikRepository.save(korisnik);
    }


}