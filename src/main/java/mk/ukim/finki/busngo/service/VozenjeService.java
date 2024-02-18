package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Vozenje;
import mk.ukim.finki.busngo.model.enums.VOZENJE_STATUS;

import java.util.List;

public interface VozenjeService {
    List<Vozenje> findVozenjaByPatnik(String email);
    List<Vozenje> findVozenjaByPatnikAndStatus(String email, VOZENJE_STATUS status);
    Vozenje start(String email, Long bId, Long pnlId, Long inlId);
    Vozenje end(Long vozenjeId, Long pnlId);
    Vozenje findById(Long id);
}
