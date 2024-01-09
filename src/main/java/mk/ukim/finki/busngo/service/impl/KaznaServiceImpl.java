package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Kazna;
import mk.ukim.finki.busngo.model.entities.Kontroli;
import mk.ukim.finki.busngo.repository.KaznaRepository;
import mk.ukim.finki.busngo.service.KaznaService;
import mk.ukim.finki.busngo.service.KontrolaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaznaServiceImpl implements KaznaService {
    private final KaznaRepository kaznaRepository;
    private final KontrolaService kontrolaService;

    public KaznaServiceImpl(KaznaRepository kaznaRepository, KontrolaService kontrolaService) {
        this.kaznaRepository = kaznaRepository;
        this.kontrolaService = kontrolaService;
    }

    @Override
    public List<Kazna> findAll() {
        return kaznaRepository.findAll();
    }

    @Override
    public List<Kazna> findAllByKontrolaId(Long kontrolaId) {
        Kontroli kontroli = kontrolaService.findById(kontrolaId);
        return kaznaRepository.findAllByKontroliByKontrolaId(kontroli);
    }
}
