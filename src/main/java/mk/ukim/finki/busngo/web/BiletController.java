package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import mk.ukim.finki.busngo.model.exceptions.InvalidPatnikIdException;
import mk.ukim.finki.busngo.service.AuthService;
import mk.ukim.finki.busngo.service.BiletService;
import mk.ukim.finki.busngo.service.PatnikService;
import mk.ukim.finki.busngo.service.TipBiletService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/bilet")
public class BiletController {
    private final BiletService biletService;
    private final TipBiletService tipBiletService;
    private final AuthService authService;
    private final PatnikService patnikService;

    public BiletController(BiletService biletService, TipBiletService tipBiletService, AuthService authService, PatnikService patnikService) {
        this.biletService = biletService;
        this.tipBiletService = tipBiletService;
        this.authService = authService;
        this.patnikService = patnikService;
    }

    @GetMapping()
    public String getAllBileti(@RequestParam(required = false) Long id,
                               @RequestParam(required = false) BILET_STATUS status,
                               Model model,
                               Authentication authentication){
        model.addAttribute("bodyContent", "listBileti");
        Patnik patnik = null;
        try{
            model.addAttribute("bileti", biletService.findAllByPatnikEmail(authentication.getName()));
        }
        catch (InvalidPatnikIdException e){
            model.addAttribute("bodyContent", "listBileti");
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "master-template";
        }

        return "master-template";
    }

    @GetMapping("/kupi")
    public String getKupiPage(Model model){
        model.addAttribute("bodyContent", "kupiBilet");
        model.addAttribute("tipbileti", tipBiletService.listAll());
        return "master-template";
    }

    @PostMapping("/kupi")
    public String kupiBilet(@RequestParam Long tipbilet, Authentication authentication){
        biletService.buy(tipbilet, LocalDateTime.now(), BILET_STATUS.INACTIVE, authentication.getName());
        return "redirect:/bilet";
    }

//    @GetMapping("/encode")
//    public String encode(){
//        biletService.encode();
//        return "redirect:/bilet";
//    }

}
