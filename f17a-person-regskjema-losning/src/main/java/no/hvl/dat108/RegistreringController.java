package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistreringController {
	
	@PostMapping("/registrer")
	public String taImotRegistrering(Model model,
			String fornavn, String etternavn, int aar) {
		
		Person p = new Person(fornavn, etternavn, aar);
		model.addAttribute("personen", p);
		return "kvittering";	
	}
}
