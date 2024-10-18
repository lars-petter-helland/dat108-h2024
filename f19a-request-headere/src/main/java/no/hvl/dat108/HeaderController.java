package no.hvl.dat108;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {
	
	@GetMapping(value = "/headers", produces="text/plain")
	@ResponseBody
	public String headers(@RequestHeader Map<String, String> headers) {
		//https://www.baeldung.com/java-maps-streams
		return headers.entrySet().stream()
				.map((Entry<String, String> e) -> String.format("Header '%s' = %s", e.getKey(), e.getValue()))
				.collect(Collectors.joining("\n"));
	}
	
	@GetMapping(value = "/host", produces="text/plain")
	@ResponseBody
	public String host(@RequestHeader(HttpHeaders.HOST) String host) {
		return "host = " + host;
	}

	@GetMapping(value = "/spraak", produces="text/plain")
	@ResponseBody
	public String spraak(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String spraak) {
		return "accept-language = " + spraak;
	}
}