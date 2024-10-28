package no.hvl.dat108.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String provAaLoggeInn(@RequestParam String username,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		//Hvis ugyldig, gå til login
		if (!InputValidator.isValidUsername(username)) {
			ra.addFlashAttribute("redirectMessage", "Brukernavn er ikke gyldig");
			return "redirect:login";
		}
		
		//Innlogging
		LoginUtil.loggInnBruker(request, username);
		
		return "redirect:webshop";
    }
}
