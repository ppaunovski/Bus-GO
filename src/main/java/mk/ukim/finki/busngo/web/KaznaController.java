package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.exceptions.InvalidPatnikIdException;
import mk.ukim.finki.busngo.service.KaznaZaRegistriranService;
import mk.ukim.finki.busngo.service.VozenjeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kazna")
public class KaznaController {
    private final KaznaZaRegistriranService kaznaZaRegistriranService;

    public KaznaController(KaznaZaRegistriranService kaznaZaRegistriranService) {
        this.kaznaZaRegistriranService = kaznaZaRegistriranService;
    }

    @GetMapping()
    public String getKaznaPage(Model model,
                                 Authentication authentication){
        model.addAttribute("bodyContent", "listKazni");
        Patnik patnik = null;
        try{
            model.addAttribute("kazni", kaznaZaRegistriranService.findAllByPatnik(authentication.getName()));
        }
        catch (InvalidPatnikIdException e){
            model.addAttribute("bodyContent", "listBileti");
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "master-template";
        }

        return "master-template";
    }
}
