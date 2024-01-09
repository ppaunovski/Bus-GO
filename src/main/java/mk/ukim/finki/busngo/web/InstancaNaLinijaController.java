package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Avtobus;
import mk.ukim.finki.busngo.model.entities.Instancanalinija;
import mk.ukim.finki.busngo.model.entities.Linija;
import mk.ukim.finki.busngo.service.AvtobusService;
import mk.ukim.finki.busngo.service.InstancaNaLinijaService;
import mk.ukim.finki.busngo.service.KontrolaService;
import mk.ukim.finki.busngo.service.LinijaService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("instanca-na-linija")
public class InstancaNaLinijaController {
    private final InstancaNaLinijaService instancaNaLinijaService;
    private final LinijaService linijaService;
    private final AvtobusService avtobusService;
    private final KontrolaService kontrolaService;

    public InstancaNaLinijaController(InstancaNaLinijaService instancaNaLinijaService, LinijaService linijaService, AvtobusService avtobusService, KontrolaService kontrolaService) {
        this.instancaNaLinijaService = instancaNaLinijaService;
        this.linijaService = linijaService;
        this.avtobusService = avtobusService;
        this.kontrolaService = kontrolaService;
    }

    @GetMapping()
    public String getList(Model model){
        model.addAttribute("bodyContent", "listInstanci");
        model.addAttribute("inls", instancaNaLinijaService.findAllActive());

        return "master-template";
    }
    @GetMapping("/start")
    public String getStartPage(Model model){
        List<Linija> linijaList = linijaService.findAll();
        List<Avtobus> avtobusList = avtobusService.findAll();
        model.addAttribute("avtobusi", avtobusList);
        model.addAttribute("linii", linijaList);
        model.addAttribute("bodyContent", "startInstanca");

        return "master-template";
    }

    @PostMapping("/start")
    public String startInstanca(@RequestParam String aRegistracija,
                                @RequestParam Long liId,
                                Model model,
                                Authentication authentication){
        Instancanalinija start = instancaNaLinijaService.start(liId, aRegistracija, authentication.getName());
//        model.addAttribute("inl", start);
//        model.addAttribute("bodyContent", "inlShow");

        return "redirect:/instanca-na-linija/" + start.getInlId();
    }

    @GetMapping("/{inlId}")
    public String getInlShow(@PathVariable Long inlId,
                             Model model){
        model.addAttribute("inl", instancaNaLinijaService.findById(inlId));
        model.addAttribute("kontroli", kontrolaService.findAllByInl(inlId));
        model.addAttribute("bodyContent", "inlShow");

        return "master-template";
    }

    @PostMapping("/{inlId}/end")
    public String endInstanca(@PathVariable Long inlId){
        Instancanalinija ended = instancaNaLinijaService.end(inlId);
        return "redirect:/instanca-na-linija/" + ended.getInlId();
    }
}
