package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.model.exceptions.InvalidLinijaIdException;
import mk.ukim.finki.busngo.repository.LinijaRepository;
import mk.ukim.finki.busngo.service.LinijaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinijaServiceImpl implements LinijaService {

    private final LinijaRepository linijaRepository;

    public LinijaServiceImpl(LinijaRepository linijaRepository) {
        this.linijaRepository = linijaRepository;
    }

    @Override
    public List<Linija> findAll() {
        return linijaRepository.findAll();
    }

    @Override
    public Linija findById(Long liId) {
        return linijaRepository.findById(liId).orElseThrow(InvalidLinijaIdException::new);
    }
}
