package uol.compass.politics.controllers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uol.compass.politics.services.PartyService;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class PartyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PartyService partyService;
    @Autowired
    private PartyController partyController;

    private static final String URL = "/politics/parties";
    private static final String URL_ID = URL+"/1";

    @Test
    void create() throws Exception{
        String jsonRequest = "{\"name\": \"Partido Progressista\", \"sigla\": \"PP\", \"ideology\": \"DIREITA\",\"dateFoundation\": \"12/10/1998\"}";
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(201));
    }
    @Test
    void update() throws Exception{
        String jsonRequest = "{\"name\": \"Partido Progressista\", \"sigla\": \"PP\", \"ideology\": \"DIREITA\",\"dateFoundation\": \"12/10/1998\"}";
        mockMvc.perform(MockMvcRequestBuilders.put(URL_ID)
                        .content(jsonRequest)

                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void delete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete(URL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void listAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void listAllAffiliates() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/politics/parties/1/affiliates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void findById ()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/politics/parties/1/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

}
