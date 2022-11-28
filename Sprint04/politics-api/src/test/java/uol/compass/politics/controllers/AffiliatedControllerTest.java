package uol.compass.politics.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uol.compass.politics.dto.response.AffiliatedResponseDto;
import uol.compass.politics.services.AffiliatedService;
import uol.compass.politics.services.PartyService;

import static org.mockito.ArgumentMatchers.any;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AffiliatedControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AffiliatedService affiliatedService;
    @MockBean
    private PartyService partyService;
    private static final String URL = "/politics/affiliates";
    private static final String URL_ID = URL+"/1";

    @Test
    void create() throws Exception{

        Mockito.when(affiliatedService.create(any())).thenReturn(new AffiliatedResponseDto());
        String jsonRequest = "{\"name\": \"Marina Silva\", \"politicalOffice\": \"PRESIDENTE\", \"birthDate\": \"10/11/1960\",\"gender\": \"FEMININO\"}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(result.getResponse().getStatus(), 201);

    }
    @Test
    void listAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(URL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    void update() throws Exception {
        String jsonRequest = "{\"name\": \"Marina Silva\", \"politicalOffice\": \"PRESIDENTE\", \"birthDate\": \"10/11/1960\",\"gender\": \"FEMININO\"}";
        mockMvc.perform(MockMvcRequestBuilders.put(URL_ID)
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    void createAssociation() throws Exception {
        String jsonRequest = "{\"idAffiliated\": 1, \"idParty\": 5}";
        mockMvc.perform(MockMvcRequestBuilders.put("/politics/affiliates/parties")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    void deleteAssociation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/politics/affiliates/1/parties/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }





}
