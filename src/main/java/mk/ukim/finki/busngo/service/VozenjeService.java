package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Vozenje;

import java.util.List;

public interface VozenjeService {
    List<Vozenje> findVozenjaByPatnik(String email);
    Vozenje start(String email, Long bId, Long pnlId, Long inlId);
    Vozenje end(Long vozenjeId, Long pnlId);
    Vozenje findById(Long id);
}
