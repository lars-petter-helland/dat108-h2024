package no.hvl.dat108.f11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KongeController {
	
	@GetMapping(value = "/kongesok")
	public String visKontoDetaljer(Model model, @RequestParam int aar) {
		
		Konge konge = Konger.norske.stream()
				.filter(k -> k.getKongeFraAar() <= aar && aar <= k.getKongeTilAar())
				.findFirst()
				.orElse(Konge.DEFAULT);
		
		model.addAttribute("konge", konge);
		return "konge";
	}
}
