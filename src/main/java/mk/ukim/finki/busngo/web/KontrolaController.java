package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Kontroli;
import mk.ukim.finki.busngo.model.exceptions.UserShouldNotBeTicketedException;
import mk.ukim.finki.busngo.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kontrola")
public class KontrolaController {

    private final KontrolaService kontrolaService;
    private final KaznaZaRegistriranService kaznaZaRegistriranService;
    private final KaznaZaNeregistriranService kaznaZaNeregistriranService;
    private final KaznaService kaznaService;
    private final PatnikService patnikService;
    private final VozacService vozacService;
    private final InstancaNaLinijaService instancaNaLinijaService;

    public KontrolaController(KontrolaService kontrolaService, KaznaZaRegistriranService kaznaZaRegistriranService, KaznaZaNeregistriranService kaznaZaNeregistriranService, KaznaService kaznaService, PatnikService patnikService, VozacService vozacService, InstancaNaLinijaService instancaNaLinijaService) {
        this.kontrolaService = kontrolaService;
        this.kaznaZaRegistriranService = kaznaZaRegistriranService;
        this.kaznaZaNeregistriranService = kaznaZaNeregistriranService;
        this.kaznaService = kaznaService;
        this.patnikService = patnikService;
        this.vozacService = vozacService;
        this.instancaNaLinijaService = instancaNaLinijaService;
    }

    @GetMapping("/{kontrolaId}")
    public String get(@PathVariable Long kontrolaId,
                      Model model){
        model.addAttribute("bodyContent", "kontrola");
        Kontroli kontroli = kontrolaService.findById(kontrolaId);

        model.addAttribute("kontrola", kontroli);
        model.addAttribute("kazni", kaznaService.findAllByKontrolaId(kontrolaId));
        model.addAttribute("patnici", patnikService.listAll());
        return "master-template";
    }
    @GetMapping("/start-for/{inlId}")
    public String getStartPage(@PathVariable Long inlId,
                               Model model,
                               Authentication authentication){
        model.addAttribute("bodyContent", "kontrola");
        Kontroli kontroli = kontrolaService.create(inlId, authentication.getName());

        model.addAttribute("kontrola", kontroli);
        return "redirect:/kontrola/" + kontroli.getKontrolaId();
    }

    @PostMapping("/{kontrolaId}/kazni-registriran")
    public String kazniRegistriran(@PathVariable Long kontrolaId,
                                   @RequestParam String dokument,
                                   @RequestParam Double iznos,
                                   @RequestParam Long patnik,
                                   Authentication authentication){
        try {

            kaznaZaRegistriranService.create(kontrolaId, dokument, iznos, patnik, authentication.getName());
        }
        catch (UserShouldNotBeTicketedException exception){
            return "redirect:/kontrola/" + kontrolaId;
        }

        return "redirect:/kontrola/" + kontrolaId;
    }

    @PostMapping("/{kontrolaId}/kazni-neregistriran")
    public String kazniNeregistriran(@PathVariable Long kontrolaId,
                                   @RequestParam String dokument,
                                   @RequestParam Double iznos,
                                   @RequestParam String telefon,
                                   @RequestParam String ime,
                                   @RequestParam String adresa,
                                   Authentication authentication){

        kaznaZaNeregistriranService.create(kontrolaId, dokument, iznos, telefon, ime, adresa, authentication.getName());

        return "redirect:/kontrola/" + kontrolaId;
    }
}
