package no.hvl.lph.dat108;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LogginnService {
	
    public boolean erLoggetInn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null) && (session.getAttribute("user") != null);
    }

    public void loggUt(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
    
    public void loggInn(HttpServletRequest request, Person person) {

        // Invalidate old session
        loggUt(request);

        // Create new fresh session
        HttpSession sesjon = request.getSession(true);

        // Store user with pre-validated username in session.
        // A "user" in the session is how we see that we have a logged in user
        sesjon.setAttribute("user", person);
    }


}
