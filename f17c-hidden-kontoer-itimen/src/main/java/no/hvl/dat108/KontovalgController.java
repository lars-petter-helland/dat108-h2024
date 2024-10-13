/*
d * Dette er et eksempel på en Spring MVC Controller.
 * 
 * En controller sin rolle i en web-applikasjon er å ta imot
 * requests (forespørsler) fra web-klienter (f.eks. weblesere).
 * 
 * I eksemplet så vi på hvordan vi får tak i request-parameteren "person",
 * og hvordan vi kan gi svar via 3 ulike responstyper (text/plain, 
 * application/json og text/html).
 * 
 * Vanligvis vil en web-applikasjon ha mange controllere ...
 */
package no.hvl.dat108;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KontovalgController {
	
	private final List<String> kontoer = List.of(
			"Kontonr: 1234.56.12345 - Saldo: 23.456,-",
			"Kontonr: 2345.34.67899 - Saldo: 123.654,-",
			"Kontonr: 6543.57.87665 - Saldo: 3.543.870,-");
	
	private final String generatedSecret = "7FQ12lkj324kj23h4k23j5657k";
	
	@GetMapping(value = "/kontovalg")
	public String visKontoDetaljer(Model model, 
			@RequestParam(name = "usersecret") String receivedSecret,
			@RequestParam(name = "kontovalg") int index) {
		
		if (!generatedSecret.equals(receivedSecret)) {
			return "error";
		}
		if (index < 0 || index >= kontoer.size()) {
			return "error";
		}
		model.addAttribute("detaljer", kontoer.get(index));
		return "kvittering";
	}
}
