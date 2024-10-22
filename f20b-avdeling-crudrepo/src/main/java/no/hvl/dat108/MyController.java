package no.hvl.dat108;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
    @Autowired private AvdelingRepo avdelingRepo;

    @GetMapping(value = "/avdelinger")
    public String avdelinger(Model model) {
    	List<Avdeling> avdelinger = avdelingRepo.findAll();
    	model.addAttribute("avdelinger", avdelinger);
    	return "avdelingerView";
    }

    @GetMapping(value = "/avdpaaid", produces = "text/plain")
    @ResponseBody
    public String avdpaaid(@RequestParam int id) {
    	Optional<Avdeling> optAvd = avdelingRepo.findById(id);
    	if (optAvd.isEmpty()) {
    		return "INGEN AVDELING";
    	}
   		return optAvd.get().toString();
    }
    
    @GetMapping(value = "/avdpaanavn", produces = "text/plain")
    @ResponseBody
    public String avdpaanavn(@RequestParam String navn) {
    	return avdelingRepo.findByNavn(navn).toString(); //Avdeling | null
    }

    //FY - Denne burde vært POST!
    @GetMapping(value = "/nyavd", produces = "text/plain")
    @ResponseBody
    public String nyavd(@RequestParam String navn) {
    	Avdeling ny = new Avdeling();
    	ny.setNavn(navn);
    	avdelingRepo.save(ny);
    	return ny.toString();
    }
    
    // ------------------------------------------------------------------------
    
//	private <T> String listToString(List<T> elementer) {
//		String resultat = elementer.stream()
//    			.map(T::toString)
//    			.collect(Collectors.joining("\n"));
//		return resultat;
//	}
}
