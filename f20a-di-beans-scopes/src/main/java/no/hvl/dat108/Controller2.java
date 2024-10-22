package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller2 {
	
	@Autowired private MinPrototypeBean minPrototypeBean;
	@Autowired private MinRequestBean minRequestBean;
	@Autowired private MinSessionBean minSessionBean;
	@Autowired private MinApplicationBean minApplicationBean;
	@Autowired private MinSingletonBean minSingletonBean;
	
	@GetMapping(value="/c2", produces="text/plain")
	@ResponseBody
	public String mapping2() {
		
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