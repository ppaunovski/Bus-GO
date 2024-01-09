package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Avtobus;
import mk.ukim.finki.busngo.model.exceptions.InvalidAvtobusRegistracijaException;
import mk.ukim.finki.busngo.repository.AvtobusRepository;
import mk.ukim.finki.busngo.service.AvtobusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvtobusServiceImpl implements AvtobusService {
    private final AvtobusRepository avtobusRepository;

    public AvtobusServiceImpl(AvtobusRepository avtobusRepository) {
        this.avtobusRepository = avtobusRepository;
    }

    @Override
    public List<Avtobus> findAll() {
        return avtobusRepository.findAll();
    }

    @Override
    public Avtobus findById(String aRegistracija) {
        return avtobusRepository.findByARegistracija(aRegistracija).orElseThrow(InvalidAvtobusRegistracijaException::new);
    }
}
