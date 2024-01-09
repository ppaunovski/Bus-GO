package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Vozac;
import mk.ukim.finki.busngo.model.exceptions.InvalidVozacIdException;
import mk.ukim.finki.busngo.repository.VozacRepository;
import mk.ukim.finki.busngo.service.VozacService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VozacServiceImpl implements VozacService {
    private final VozacRepository vozacRepository;

    public VozacServiceImpl(VozacRepository vozacRepository) {
        this.vozacRepository = vozacRepository;
    }

    @Override
    public List<Vozac> findAll() {
        return vozacRepository.findAll();
    }

    @Override
    public Vozac findByEmail(String email) {
        return vozacRepository.findByKEmail(email).orElseThrow(InvalidVozacIdException::new);
    }
}
