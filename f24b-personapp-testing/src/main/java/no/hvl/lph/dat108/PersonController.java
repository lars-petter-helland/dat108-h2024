package no.hvl.lph.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
	
	/*
	 * PersonValidator og LogginnService brukes ikke i eksemplet,
	 * men generelt kan man tenke seg at en controller bruker 
	 * slike klasser. De er tatt med for å vise at vi må ta hensyn 
	 * til alle avhengigheter ved enheltstesting av PersonController.
	 */
	@Autowired PersonValidator personValidator;
	@Autowired LogginnService logginnService;
	
	@Autowired PersonService personservice;
	
	@GetMapping(path = "/personerJson", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<String> personerJson() {
		return personservice.navnPaaAlleFodtIAar2000();
	}

	@GetMapping(path = "/personerHtml")
	public String personerHtml(Model model) {
		List<String> navneliste = personservice.navnPaaAlleFodtIAar2000();
		model.addAttribute("navneliste", navneliste);
		return "navneliste";
	}
}
