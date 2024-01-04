package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.exceptions.InvalidPatnikIdException;
import mk.ukim.finki.busngo.repository.PatnikRepository;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatnikServiceImpl implements PatnikService {
    private final PatnikRepository patnikRepository;

    public PatnikServiceImpl(PatnikRepository patnikRepository) {
        this.patnikRepository = patnikRepository;
    }

    @Override
    public List<Patnik> listAll() {
        return patnikRepository.findAll();
    }

    @Override
    public Patnik findById(Long id) {
        return patnikRepository.findById(id).orElseThrow(InvalidPatnikIdException::new);
    }
}
