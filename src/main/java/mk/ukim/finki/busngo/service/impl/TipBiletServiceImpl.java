package mk.ukim.finki.busngo.service.impl;

import mk.ukim.finki.busngo.model.entities.Tipbilet;
import mk.ukim.finki.busngo.repository.TipBIletRepository;
import mk.ukim.finki.busngo.service.TipBiletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipBiletServiceImpl implements TipBiletService {
    private final TipBIletRepository tipBIletRepository;

    public TipBiletServiceImpl(TipBIletRepository tipBIletRepository) {
        this.tipBIletRepository = tipBIletRepository;
    }

    @Override
    public List<Tipbilet> listAll() {
        return tipBIletRepository.findAll();
    }
}
