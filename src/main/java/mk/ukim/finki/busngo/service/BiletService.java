package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Bilet;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;

import java.time.LocalDateTime;
import java.util.List;

public interface BiletService {
    List<Bilet> listAll();
    List<Bilet> findAllByPatnikId(Long id);
    List<Bilet> findAllByPatnikIdAndStatus(Long id, BILET_STATUS status);

    Bilet buy(Long tipbilet, LocalDateTime now, BILET_STATUS biletStatus, String name);
}
