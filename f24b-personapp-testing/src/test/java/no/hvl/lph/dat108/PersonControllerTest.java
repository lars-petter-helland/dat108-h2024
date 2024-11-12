package no.hvl.lph.dat108;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest //(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    //Disse to er ikke i bruk, men kan mockes og injectes på denne måten 
    @MockBean private PersonValidator personValidator;
    @MockBean private LogginnService logginnService;
    
    @MockBean private PersonService personService;
    
    @BeforeEach
    public void oppsett() {
    	when(personService.navnPaaAlleFodtIAar2000())
    			.thenReturn(List.of("Per", "Pål"));
    }
    
    @Test
    public void testPersonerJson() throws Exception {

        mockMvc.perform(get("/personerJson"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("[0]").value("Per"));
    }
    
    @Test
    public void testPersonerHtml() throws Exception {
    	
        mockMvc.perform(get("/personerHtml"))
            .andExpect(status().isOk())
            .andExpect(view().name("navneliste"))
            .andExpect(model().attributeExists("navneliste"));
    }
}
