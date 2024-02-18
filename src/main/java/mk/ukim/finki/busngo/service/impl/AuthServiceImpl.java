package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Kondukter;
import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Vozac;
import mk.ukim.finki.busngo.model.enums.VrabotenType;
import mk.ukim.finki.busngo.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.busngo.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.busngo.repository.KondukterRepository;
import mk.ukim.finki.busngo.repository.KorisnikRepository;
import mk.ukim.finki.busngo.repository.PatnikRepository;
import mk.ukim.finki.busngo.repository.VozacRepository;
import mk.ukim.finki.busngo.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {
    private final KorisnikRepository korisnikRepository;
    private final PatnikRepository patnikRepository;
    private final VozacRepository vozacRepository;
    private final KondukterRepository kondukterRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatnikService patnikService;
    private final KondukterService kondukterService;
    private final VozacService vozacService;

    public AuthServiceImpl(KorisnikRepository korisnikRepository, PatnikRepository patnikRepository, VozacRepository vozacRepository, KondukterRepository kondukterRepository, PasswordEncoder passwordEncoder, PatnikService patnikService, KondukterService kondukterService, VozacService vozacService) {
        this.korisnikRepository = korisnikRepository;
        this.patnikRepository = patnikRepository;
        this.vozacRepository = vozacRepository;
        this.kondukterRepository = kondukterRepository;
        this.passwordEncoder = passwordEncoder;
        this.patnikService = patnikService;
        this.kondukterService = kondukterService;
        this.vozacService = vozacService;
    }

    @Override
    public Korisnik login(String email, String password) {
        if(email == null || password == null || email.isEmpty() || password.isEmpty())
            throw new InvalidCredentialsException();
        return korisnikRepository.findByKEmailAndKLozinka(email, password).orElseThrow(InvalidCredentialsException::new);
    }

    @Override
    public Korisnik registerPatnik(String ime, String email, String password, String confirmPassword, String address, String telefon) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        if (!password.equals(confirmPassword)) {
            throw new InvalidCredentialsException();
        }

        if(this.korisnikRepository.findByKEmail(email).isPresent()) {
            throw new UserAlreadyExistsException(email);
        }

        Patnik korisnik = new Patnik();
        korisnik.setKIme(ime);
        korisnik.setKAdresa(address);
        korisnik.setKLozinka(passwordEncoder.encode(password));
        korisnik.setKEmail(email);
        korisnik.setKTelefon(telefon);
        korisnik.setKIsAdmin(false);

        return patnikRepository.save(korisnik);
    }

    @Override
    public Korisnik registerVraboten(String ime, String email, String password, String confirmPassword, String address, String telefon, VrabotenType type, Double salary) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        if (!password.equals(confirmPassword)) {
            throw new InvalidCredentialsException();
        }

        if(this.korisnikRepository.findByKEmail(email).isPresent()) {
            throw new UserAlreadyExistsException(email);
        }


        switch (type){
            case ADMIN:
                Korisnik korisnik = new Korisnik();
                korisnik.setKIme(ime);
                korisnik.setKAdresa(address);
                korisnik.setKLozinka(passwordEncoder.encode(password));
                korisnik.setKEmail(email);
                korisnik.setKTelefon(telefon);
                korisnik.setKIsAdmin(true);
                return korisnikRepository.save(korisnik);
            case VOZAC:
                Vozac vozac = new Vozac();
                vozac.setKIme(ime);
                vozac.setKAdresa(address);
                vozac.setKLozinka(passwordEncoder.encode(password));
                vozac.setKEmail(email);
                vozac.setKTelefon(telefon);
                vozac.setKIsAdmin(false);
                vozac.setVPlata(salary);
                vozac.setVDatumNaVrabotuvanje(Date.valueOf(LocalDate.now()));
                this.korisnikRepository.save(vozac);

                return vozacRepository.save(vozac);
            case KONDUKTER:
                Kondukter kondukter = new Kondukter();
                kondukter.setKIme(ime);
                kondukter.setKAdresa(address);
                kondukter.setKLozinka(passwordEncoder.encode(password));
                kondukter.setKEmail(email);
                kondukter.setKTelefon(telefon);
                kondukter.setKIsAdmin(false);
                kondukter.setVPlata(salary);
                kondukter.setVDatumNaVrabotuvanje(Date.valueOf(LocalDate.now()));
                this.korisnikRepository.save(kondukter);

                return kondukterRepository.save(kondukter);
        }
        return null;
    }


}
