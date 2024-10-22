package no.hvl.dat108;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnsattRepo extends JpaRepository<Ansatt, Integer> {
	List<Ansatt> findAllByAvdelingId(int id);
	Ansatt findByNavn(String navn);
	
}
