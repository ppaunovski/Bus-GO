package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Kazna;

import java.util.List;

public interface KaznaService {
    List<Kazna> findAll();
    List<Kazna> findAllByKontrolaId(Long kontrolaId);
}
