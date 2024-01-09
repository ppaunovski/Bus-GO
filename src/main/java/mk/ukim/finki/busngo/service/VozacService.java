package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Vozac;
import mk.ukim.finki.busngo.repository.VozacRepository;

import java.util.List;

public interface VozacService {
    List<Vozac> findAll();
    Vozac findByEmail(String email);
}
