package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PersonController {

	@GetMapping("/personskjema")
	public String personskjema() {
		return "personskjema";
	}
	
	@GetMapping("/sjekkPerson")
	public String sjekkPerson(Model model,
			@ModelAttribute("person") Person person) {
		
		return "personkvittering";
	}

}
