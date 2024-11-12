package no.hvl.lph.dat108.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;
import no.hvl.lph.dat108.solution.Kryptokalkulator;

@Controller 
public class KryptoController {
	
	@Autowired
	private Kryptokalkulator kk;

	@GetMapping("/kjopekrypto") //For å få opp skjemaet
	public String skjema(Model model) {
		model.addAttribute("kryptokoder", Krypto.values());
		model.addAttribute("fiatkoder", Fiat.values());
		return "kjopekrypto";
	}

	@PostMapping("/kjopekrypto") //For å behandle ønsket kjøp
	@ResponseBody //Returnerer her HTML rett fra Controller uten å bruke View/JSP.
	public String kjope(
			@RequestParam String antall, 
			@RequestParam String krypto, 
			@RequestParam String fiat) {
		
		/*
		 * Her burde jo absolutt input vært validert før man går
		 * videre. Bruker man f.eks. komma i stedet for punktum
		 * i antall-parameteren vil parsingen nedenfor kræsje ...
		 */
		
		/* 
		 * Det er denne metoden vi ønsker å enhetsteste!
		 * Beregner den riktig beløp gitt inputdata og kurser?
		 */
		double belop = kk.kjope(Double.parseDouble(antall), 
				Krypto.valueOf(krypto), Fiat.valueOf(fiat));
		/* ---------------------------------------------------- */
		
		String belopToDesimaler = String.format("%,.2f", belop);
		
		return """
				<!DOCTYPE html>
				<html><body>
					<h2>Kryptokjøp resultat</h2>
					<p>Du kjøper""" + " " + antall + " " + krypto + ".<br>"
					+ "Totalt belop blir " + belopToDesimaler + " " + fiat + ".</p>" + """
					<p><a href=\"kjopekrypto\">Kjope mer</a></p>
				</body></html>
			""";
	}
	
}
