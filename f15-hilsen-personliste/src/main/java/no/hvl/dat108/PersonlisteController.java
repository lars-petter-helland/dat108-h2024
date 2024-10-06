package no.hvl.dat108;

import static no.hvl.dat108.People.people;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonlisteController {
	
	@GetMapping("/api/personer")
	@ResponseBody //Betyr at responsen er direkte fra returverdien herfra.
	public List<Person> personer() {
		return people;
	}
	
	//Uten @ResponseBody vil returverdien være navnet på Viewet.
	//Her ser vi altså hvordan Model-View-Controller gjøres i Spring MVC. 
	@GetMapping("/personliste-ssr")
	public String personliste(Model model) {
		model.addAttribute("personliste", people); //Modellen fylles med data
		return "personlisteView"; 	//Navnet på viewet. Se application.properties
									//for hvilket filnavn dette mappes til.
	}
}
