package no.hvl.dat108;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class MinApplicationBean {
	
	@PostConstruct
	public void init() {
		System.err.println("MinApplicationBean.init() ..");
	}
}
