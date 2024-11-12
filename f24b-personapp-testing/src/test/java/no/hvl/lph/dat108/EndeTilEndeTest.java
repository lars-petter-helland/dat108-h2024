package no.hvl.lph.dat108;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/*
 * @SpringBootTest laster hele konteksten, dvs. det er en full
 * ende-til-ende-test.
 * 
 * @WebMvcTest kan brukes for å enhetsteste controller, men da
 * må evt. servicer og repos mockes med @MockBean. Kanskje det
 * kunne vært noe å testet ut.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EndeTilEndeTest {

    @Autowired
    private MockMvc mockMvc;

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
