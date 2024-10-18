package no.hvl.dat108;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BestillingController {
	
//	@PostMapping("/bestilling")
//	public String bestillUtenPrg(@RequestParam String vare, Model model) {
//		System.err.println("Uten PRG: Det blir nå bestilt en " + vare);
//
//		model.addAttribute("vare", vare);
//		return "kvitteringView";
//	}

	@PostMapping("/bestilling")
	public String bestillMedPrg(@RequestParam String vare, RedirectAttributes ra, 
			HttpSession session, Model model) {
		System.err.println("Med PRG:  Det blir nå bestilt en " + vare);
		
		//https://www.baeldung.com/spring-web-flash-attributes
		//Alt. 0b
		model.addAttribute("MAvare", vare);
		//Alt. 1
		session.setAttribute("SAvare", vare);
		//Alt. 2
		ra.addAttribute("RAvare", vare);
		//Alt. 3
		ra.addFlashAttribute("RFAvare", vare);
		
		return "redirect:kvittering";
	}

	@GetMapping("/kvittering")
	public String kvittering(RedirectAttributes ra,
			HttpServletRequest request,
			HttpSession session, Model model) {
		
//		System.err.println("MAvare  : " + model.getAttribute("MAvare"));
//		System.err.println("SAvare  : " + session.getAttribute("SAvare"));
//		System.err.println("RAvare  : " + ra.getAttribute("RAvare"));
//		System.err.println("RFAvare : " + RequestContextUtils.getInputFlashMap(request).get("RFAvare"));
		
		return "kvitteringView";
	}
}