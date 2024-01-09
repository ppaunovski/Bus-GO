package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.model.entities.Postojkanalinija;
import mk.ukim.finki.busngo.model.exceptions.InvalidPostojkaNaLinijaIdException;
import mk.ukim.finki.busngo.repository.PostojkaNaLinijaRepository;
import mk.ukim.finki.busngo.service.LinijaService;
import mk.ukim.finki.busngo.service.PostojkaNaLinijaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostojkaNaLinijaServiceImpl implements PostojkaNaLinijaService {
    private final PostojkaNaLinijaRepository postojkaNaLinijaRepository;
    private final LinijaService linijaService;

    public PostojkaNaLinijaServiceImpl(PostojkaNaLinijaRepository postojkaNaLinijaRepository, LinijaService linijaService) {
        this.postojkaNaLinijaRepository = postojkaNaLinijaRepository;
        this.linijaService = linijaService;
    }

    @Override
    public List<Postojkanalinija> findAll() {
        return postojkaNaLinijaRepository.findAll();
    }

    @Override
    public Postojkanalinija findById(Long id) {
        return postojkaNaLinijaRepository.findById(id).orElseThrow(InvalidPostojkaNaLinijaIdException::new);
    }

    @Override
    public List<Postojkanalinija> findByLinija(Long liId) {
        Linija linija = linijaService.findById(liId);
        return postojkaNaLinijaRepository.findAllByLinijaByLiId(linija);
    }

    @Override
    public List<Postojkanalinija> findByLinijaAfterRedenBroj(Long liId, Short redenBroj) {
        Linija linija = linijaService.findById(liId);
        return postojkaNaLinijaRepository.findAllByLinijaByLiIdAndPnlRedenBrojGreaterThan(linija, redenBroj);
    }
}
