package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {
	
	@Autowired private MinPrototypeBean minPrototypeBean;
	@Autowired private MinRequestBean minRequestBean;
	@Autowired private MinSessionBean minSessionBean;
	@Autowired private MinApplicationBean minApplicationBean;
	@Autowired private MinSingletonBean minSingletonBean;

	@GetMapping(value="/jippi")
	public String visViaJsp(Model model) {
		model.addAttribute("appBean", minApplicationBean);
		return "beans";
	}
	
	@GetMapping(value="/c1", produces="text/plain")
	@ResponseBody
	public String mapping1() {
		
		StringBuilder sb = new StringBuilder("");
		sb.append(this.toString() + "\n");
		sb.append("\nHer ser vi Beans med ulike scopes. Prøv både /c1 og /c2, og både"
				 +"\ni ulike faner og med ulike nettlesere samtidig. Rerfresh sidene," 
				 +"\nobserver og lær.\n");
		
		sb.append("\n" + minRequestBean);
		sb.append("\n" + minSessionBean);
		sb.append("\n" + minApplicationBean);
		sb.append("\n" + minPrototypeBean);
		sb.append("\n" + minSingletonBean);
		
		return sb.toString();
	}
	

}