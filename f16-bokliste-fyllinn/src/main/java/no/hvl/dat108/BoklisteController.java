package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoklisteController {

	@GetMapping("/alleboker")
	public String alleBoker(Model model) {
		return null; //TODO fyll inn
	}

	@GetMapping("/noenboker")
	public String noenBoker(Model model) {
		return null; //TODO fyll inn
	}
}
