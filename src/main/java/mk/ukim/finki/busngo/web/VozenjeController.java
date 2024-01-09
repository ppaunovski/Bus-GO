package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.model.entities.Patnik;
import mk.ukim.finki.busngo.model.entities.Vozenje;
import mk.ukim.finki.busngo.model.exceptions.InvalidPatnikIdException;
import mk.ukim.finki.busngo.model.exceptions.InvalidPostojkaNaLinijaIdException;
import mk.ukim.finki.busngo.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vozenje")
public class VozenjeController {
    private final VozenjeService vozenjeService;
    private final PostojkaNaLinijaService postojkaNaLinijaService;
    private final InstancaNaLinijaService instancaNaLinijaService;
    private final BiletService biletService;

    public VozenjeController(VozenjeService vozenjeService, PostojkaNaLinijaService postojkaNaLinijaService, InstancaNaLinijaService instancaNaLinijaService, BiletService biletService) {
        this.vozenjeService = vozenjeService;
        this.postojkaNaLinijaService = postojkaNaLinijaService;
        this.instancaNaLinijaService = instancaNaLinijaService;
        this.biletService = biletService;
    }

    @GetMapping()
    public String getVozenjePage(Model model,
                                 Authentication authentication){
        model.addAttribute("bodyContent", "listVozenja");
        Patnik patnik = null;
        try{
            model.addAttribute("vozenja", vozenjeService.findVozenjaByPatnik(authentication.getName()));
        }
        catch (InvalidPatnikIdException e){
            model.addAttribute("bodyContent", "listBileti");
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "master-template";
        }

        return "master-template";
    }

//    @GetMapping("/start")
//    public String getStartVozenjePagePostojkaPage(Model model){
//        model.addAttribute("postojki", postojkaNaLinijaService.findAll());
//        model.addAttribute("bodyContent", "choosePostojka");
//
//        return "master-template";
//    }
    @GetMapping("/start")
    public String getStartVozenjePageAll(@RequestParam(required = false) Long pnlId,
                                         Model model,
                                         Authentication authentication){
        try{
            if(pnlId != null){
                model.addAttribute("postojka", postojkaNaLinijaService.findById(pnlId));
                model.addAttribute("instanci", instancaNaLinijaService.findByPnlId(pnlId));
            }
            model.addAttribute("postojki", postojkaNaLinijaService.findAll());

            model.addAttribute("bileti", biletService.findAllByPatnikEmail(authentication.getName()));
            model.addAttribute("bodyContent", "startVozenje");
        }
        catch (InvalidPostojkaNaLinijaIdException | InvalidPatnikIdException exception){
            model.addAttribute("bodyContent", "listBileti");
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "master-template";
        }

        return "master-template";
    }

    @PostMapping("/start")
    public String startVozenje(@RequestParam Long pnlId,
                               @RequestParam Long inlId,
                               @RequestParam Long bId,
                               Authentication authentication,
                               Model model){
        try{
            vozenjeService
                    .start(authentication.getName(), bId, pnlId, inlId);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            model.addAttribute("bodyContent", "listBileti");
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "master-template";
        }

        return "redirect:/vozenje";
    }

    @GetMapping("/{vozenjeId}/end")
    public String getEndVozenje(@PathVariable Long vozenjeId,
                                Model model){
        Vozenje vozenje = vozenjeService.findById(vozenjeId);
        model.addAttribute("vozenje", vozenjeService.findById(vozenjeId));
        model.addAttribute("pnls",
                postojkaNaLinijaService
                        .findByLinijaAfterRedenBroj(Long.valueOf(vozenje
                                .getInstancanalinijaByInlId()
                                .getLinijaByLiId()
                                .getLiId()),
                                vozenje.getPostojkanalinijaByKacuvaPnlId().getPnlRedenBroj()));

        model.addAttribute("bodyContent", "endVozenje");

        return "master-template";
    }

    @PostMapping("/{vozenjeId}/end")
    public String endVozenje(@PathVariable Long vozenjeId,
                             @RequestParam Long pnlEndId){
        Vozenje end = vozenjeService.end(vozenjeId, pnlEndId);
        return "redirect:/vozenje";
    }
}
