package no.hvl.dat108;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoklisteController {

	@GetMapping("/noenboker")
	public String noenBoker(Model model, String forfatter, 
			String sortering, String[] genre) {
		
		/* Legger inn aktuelle comparatorer i et Map. Slipper da if-else
		 * for å velge comparator, men kan bruke et direkte oppslag i stedet. 
		 * Dette map-et kunne gjerne vært plassert i Bok-/Boker-klassen i 
		 * stedet for her i Controlleren.
		 */
		Map<String, Comparator<Bok>> comp = new HashMap<>();
		comp.put("paaTittel", Comparator.comparing(Bok::getTittel));
		comp.put("paaAar", Comparator.comparing(Bok::getUtgivelsesaar));
		
		List<String> valgteGenre = List.of(genre);
		
		List<Bok> noenBoker = Boker.alleBoker.stream()
				.filter(b -> b.getForfatter().contains(forfatter))
				.filter(b -> valgteGenre.contains(b.getGenre()))
				.sorted(comp.get(sortering))
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
