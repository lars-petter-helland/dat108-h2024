package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SjekkAarController {

	@GetMapping("/skjema")
	public String aarstallSkjema() {
		return "skjema";
	}

	@GetMapping("/sjekkAar")
	public String sjekkFodselsaar(Model model,
			String fodselsaar) {

		//"Guard" - Vi sjekker og håndterer feilsituasjoner først
		boolean gyldig = InputValidator.erGyldigAarstall(fodselsaar);
		
		// ...
		
		//Kommer vi hit, er alt i orden
		model.addAttribute("gyldig", gyldig);
		return "tilbakemelding";
	}
	
}
