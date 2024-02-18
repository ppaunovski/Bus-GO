package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.entities.Korisnik;
import mk.ukim.finki.busngo.model.enums.VrabotenType;
import mk.ukim.finki.busngo.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.busngo.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.busngo.service.AuthService;
import mk.ukim.finki.busngo.service.KorisnikService;
import mk.ukim.finki.busngo.service.PatnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;
    private final KorisnikService korisnikService;
    private final PatnikService patnikService;

    public RegisterController(AuthService authService, KorisnikService korisnikService, PatnikService patnikService) {
        this.authService = authService;
        this.korisnikService = korisnikService;
        this.patnikService = patnikService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("types", VrabotenType.values());

        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           @RequestParam String address,
                           @RequestParam String phone,
                           @RequestParam(required = false)VrabotenType vrabotenType,
                           @RequestParam(required = false) Double salary
                           ) {
        try{
            Korisnik korisnik;
            if(vrabotenType != null){
                 korisnik = this.authService.registerVraboten(name, email, password, confirmPassword, address, phone, vrabotenType, salary);

            }
            else
                korisnik = this.authService.registerPatnik(name, email, password, confirmPassword, address, phone);
            return "redirect:/login";
        } catch (InvalidCredentialsException | UserAlreadyExistsException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

//    @PostMapping
//    public String registerVraboten(@RequestParam String name,
//                                   @RequestParam String email,
//                                   @RequestParam String password,
//                                   @RequestParam String confirmPassword,
//                                   @RequestParam String address,
//                                   @RequestParam String phone){
//
//    }

}
