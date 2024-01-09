package mk.ukim.finki.busngo.service;

import mk.ukim.finki.busngo.model.entities.Postojkanalinija;

import java.util.List;

public interface PostojkaNaLinijaService {
    List<Postojkanalinija> findAll();
    Postojkanalinija findById(Long id);
    List<Postojkanalinija> findByLinija(Long liId);
    List<Postojkanalinija> findByLinijaAfterRedenBroj(Long liId, Short redenBroj);
}
