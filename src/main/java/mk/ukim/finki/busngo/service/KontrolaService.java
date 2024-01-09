package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Kontroli;

import java.util.List;

public interface KontrolaService {
    List<Kontroli> findAll();
    Kontroli create(Long inlId, String email);

    Kontroli findById(Long kontrolaId);

    List<Kontroli> findAllByInl(Long inlId);
}
