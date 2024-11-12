package no.hvl.lph.dat108;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	PersonRepo personRepo;
	
	List<String> navnPaaAlleFodtIAar2000() {
		return personRepo.findAll().stream()
				.filter(p -> p.getFodselsaar() == 2000)
				.map(p -> p.getNavn())
				.distinct()
				.toList();
	}
}
