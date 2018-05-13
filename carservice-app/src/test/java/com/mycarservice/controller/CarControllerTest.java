package com.mycarservice.controller;

import com.google.gson.Gson;
import com.mycarservice.dto.CarDto;
import com.mycarservice.dto.CarDtoTestStub;
import com.mycarservice.service.CarService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.FileWriter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CarControllerTest {

    CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
    CarDto carDto = carDtoTestStub.setTestCarDto();

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    /* @Autowired
     private WebApplicationContext wac;
    */

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        /*this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();*/
        //TODO what is the difference in above?
    }

    @Test
    public void testAddCarAttributesHttpSuccessful() throws Exception {
        //TODO: throws Exception?
        Gson gson = new Gson();

        gson.toJson(carDto, new FileWriter("C:\\Maven\\CarService\\carservice-app\\file.json"));
        String jsonCarDto = gson.toJson(carDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/car/insertCar").contentType(MediaType.APPLICATION_JSON).
                content(jsonCarDto)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

       /* Mockito.verify(carService).addCarInstance(carDto); should this actually be included*/
    }

    @Test
    public void testAddCarAttributesHttpFailed() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/car/insertCar").content("failed")).
                andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testGetCarEntityFromDatabase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/getStoredCarData")).
                andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testGetExactCarEntityFromDatabase () throws Exception{
    /*    Gson gson = new Gson();

        gson.toJson(carDto, new FileWriter("C:\\Maven\\CarService\\carservice-app\\file.json"));
        String jsonCarDto = gson.toJson(carDto);

             this.mockMvc.perform(MockMvcRequestBuilders.post("/car/insertCar").contentType(MediaType.APPLICATION_JSON).
                content(jsonCarDto)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());*/

        mockMvc.perform(MockMvcRequestBuilders.get("/car/getStoredCarData").accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).
                andExpect(jsonPath("$.carId", Matchers.is(111)));

    }
}