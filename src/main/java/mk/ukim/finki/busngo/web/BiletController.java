package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.enums.BILET_STATUS;
import mk.ukim.finki.busngo.service.AuthService;
import mk.ukim.finki.busngo.service.BiletService;
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

    public BiletController(BiletService biletService, TipBiletService tipBiletService, AuthService authService) {
        this.biletService = biletService;
        this.tipBiletService = tipBiletService;
        this.authService = authService;
    }

    @GetMapping()
    public String getAllBileti(@RequestParam(required = false) Long id,
                               @RequestParam(required = false) BILET_STATUS status,
                               Model model){
        model.addAttribute("bodyContent", "listBileti");
        model.addAttribute("bileti", biletService.listAll());
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

}
