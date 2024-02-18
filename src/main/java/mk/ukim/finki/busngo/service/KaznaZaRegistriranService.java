package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Kazna;
import mk.ukim.finki.busngo.model.entities.Kaznazaregistriran;
import mk.ukim.finki.busngo.model.exceptions.UserShouldNotBeTicketedException;

import java.util.List;

public interface KaznaZaRegistriranService {
    List<Kaznazaregistriran> findAllByPatnik(String email);

    Kaznazaregistriran create(Long kontrolaId, String dokument, Double iznos, Long patnik, String email) throws UserShouldNotBeTicketedException;
    Kaznazaregistriran pay(Long kaznaId);
    Kaznazaregistriran findById(Long id);
}
