package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Kondukter;

import java.util.List;

public interface KondukterService {
    List<Kondukter> findAll();
    Kondukter findByEmail(String email);
}
