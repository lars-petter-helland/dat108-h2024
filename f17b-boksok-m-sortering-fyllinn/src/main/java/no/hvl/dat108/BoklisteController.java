package no.hvl.dat108;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoklisteController {

	@GetMapping("/noenboker")
	public String noenBoker(Model model, String forfatter) {

		List<Bok> noenBoker = Boker.alleBoker.stream()
				.filter(b -> b.getForfatter().contains(forfatter))
				.toList();
		
		model.addAttribute("boker", noenBoker);
		
		return"boklisteView";

	}

	@GetMapping("/alleboker")
	public String alleBoker(Model model) {
		model.addAttribute("boker", Boker.alleBoker);
		return "boklisteView";
	}

}
