package no.hvl.dat108;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Sjekke denne?:
 * https://medium.com/@AlexanderObregon/working-with-cookies-in-spring-mvc-using-cookievalue-annotation-7979205bb349
 */

@Controller
public class HomeController {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH:mm:ss");

	@GetMapping("/home")
	public String home(
			@CookieValue(name="sisteBesok", required=false) String sisteBesok,
			Model model, HttpServletResponse response) {
		
		if(sisteBesok == null) { //evt. kan man bruke Optional
			model.addAttribute("melding", "Hei. Velkommen første gang til oss.");
		} else {
			model.addAttribute("melding", "Hei. Ser du var sist inne " + sisteBesok);
		}
		
		Cookie c = new Cookie("sisteBesok", LocalDateTime.now().format(formatter));
		c.setMaxAge(10);
		response.addCookie(c);
		
		return "homeView";
	}

}