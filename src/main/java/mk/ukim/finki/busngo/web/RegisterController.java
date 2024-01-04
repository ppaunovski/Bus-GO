package mk.ukim.finki.busngo.web;

import mk.ukim.finki.busngo.model.enums.Role;
import mk.ukim.finki.busngo.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.busngo.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.busngo.service.AuthService;
import mk.ukim.finki.busngo.service.KorisnikService;
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

    public RegisterController(AuthService authService, KorisnikService korisnikService) {
        this.authService = authService;
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           @RequestParam String address,
                           @RequestParam String phone
    ) {
        try{
            this.authService.register(name, email, password, confirmPassword, address, phone);
            return "redirect:/login";
        } catch (InvalidCredentialsException | UserAlreadyExistsException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
