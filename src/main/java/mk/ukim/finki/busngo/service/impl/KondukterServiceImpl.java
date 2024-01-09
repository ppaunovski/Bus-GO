package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Kondukter;
import mk.ukim.finki.busngo.model.exceptions.InvalidUserId;
import mk.ukim.finki.busngo.repository.KondukterRepository;
import mk.ukim.finki.busngo.service.KondukterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KondukterServiceImpl implements KondukterService {
    private final KondukterRepository kondukterRepository;

    public KondukterServiceImpl(KondukterRepository kondukterRepository) {
        this.kondukterRepository = kondukterRepository;
    }

    @Override
    public List<Kondukter> findAll() {
        return kondukterRepository.findAll();
    }

    @Override
    public Kondukter findByEmail(String email) {
        return kondukterRepository.findByKEmail(email).orElseThrow(InvalidUserId::new);
    }
}
