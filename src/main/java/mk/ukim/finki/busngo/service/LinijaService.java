package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Linija;

import java.util.List;

public interface LinijaService {
    List<Linija> findAll();

    Linija findById(Long liId);
}
