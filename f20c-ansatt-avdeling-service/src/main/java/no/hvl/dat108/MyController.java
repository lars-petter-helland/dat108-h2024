package no.hvl.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
    @Autowired 
    private FirmaService aService;

    @GetMapping(value = "/avdelinger")
    @ResponseBody
    public List<Avdeling> avdelinger() {
    	return aService.finnAlleAvdelinger();
    }
    
    @GetMapping(value = "/ansatte")
    @ResponseBody
    public List<Ansatt> ansatte() {
    	return aService.finnAlleAnsatte();
    }
    
    @GetMapping(value = "/snittlonnIT", produces = "text/plain")
    @ResponseBody
    public String snittlonn() {
    	return "" + aService.snittlonn("IT");
    }

    @GetMapping(value = "/erikFlytter", produces = "text/plain")
    @ResponseBody
    public String erikFlytter(@RequestParam String tilAvdeling) {
    	
    	aService.erikFlytterTil(tilAvdeling);
    	
    	Ansatt erik = aService.finnAnsattMedNavn("Erik");
    	if(erik != null) {
        	return "" + erik;
    	}
    	return "NOE GIKK GALT!";
    }
    
}
