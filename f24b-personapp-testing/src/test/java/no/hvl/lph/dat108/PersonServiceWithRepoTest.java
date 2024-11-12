package no.hvl.lph.dat108;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceWithRepoTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testGetUserById() {
        List<String> navneliste = personService.navnPaaAlleFodtIAar2000();
        assertNotNull(navneliste);
    }
}
