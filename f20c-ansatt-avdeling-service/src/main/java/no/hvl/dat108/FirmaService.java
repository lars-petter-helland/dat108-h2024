package no.hvl.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmaService {

    @Autowired private AvdelingRepo avdelingRepo;
    @Autowired private AnsattRepo ansattRepo;

    public List<Avdeling> finnAlleAvdelinger() {
    	return avdelingRepo.findAll();
    }
    public Avdeling finnAvdelingMedId(int id) {
    	return avdelingRepo.findById(id).orElse(null);
    }
    public Avdeling finnAvdelingMedNavn(String navn) {
    	return avdelingRepo.findByNavn(navn);
    }

    public List<Ansatt> finnAlleAnsatte() {
    	return ansattRepo.findAll();
    }
    public Ansatt finnAnsattMedId(int id) {
    	return ansattRepo.findById(id).orElse(null);
    }
    public Ansatt finnAnsattMedNavn(String navn) {
    	return ansattRepo.findByNavn(navn);
    }
    
    // --
    
	public int snittlonn(String avdNavn) {
		Avdeling avdeling = avdelingRepo.findByNavn(avdNavn);
		List<Ansatt> aiAvdeling = ansattRepo.findAllByAvdelingId(avdeling.getId());
		
		int sum = aiAvdeling.stream().mapToInt(a -> a.getManedslonn()).sum();
		int antall = aiAvdeling.size();
		
		return sum/antall;
	}

	public void erikFlytterTil(String avnNavn) {
		
		Ansatt erik = ansattRepo.findByNavn("Erik");
		Avdeling avd = avdelingRepo.findByNavn(avnNavn);
		
		if (erik != null && avd != null) {
			erik.setAvdeling(avd);
			ansattRepo.save(erik);
		}
	}
}
