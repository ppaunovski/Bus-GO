package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Avtobus;
import mk.ukim.finki.busngo.repository.AvtobusRepository;

import java.util.List;

public interface AvtobusService {
    List<Avtobus> findAll();

    Avtobus findById(String aRegistracija);
}
