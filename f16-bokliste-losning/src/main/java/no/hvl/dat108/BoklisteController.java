package no.hvl.dat108;

import static no.hvl.dat108.Boker.alleBoker;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoklisteController {

	@GetMapping("/alleboker")
	public String alleBoker(Model model) {
		model.addAttribute("bokliste", alleBoker);
		return "boklisteView";
	}

	@GetMapping("/noenboker")
	public String noenBoker(Model model, 
			@RequestParam(required = false) String forfatter) {

		if (forfatter == null || forfatter.trim().isEmpty()) {
			model.addAttribute("bokliste", alleBoker);

		} else {
			
			List<Bok> noenBoker = alleBoker.stream()
					.filter(b -> b.getForfatter().contains(forfatter))
					.toList();
			model.addAttribute("bokliste", noenBoker);
		}
		return "boklisteView";
	}
}
