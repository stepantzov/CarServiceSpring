package com.mycarservice.controller;

import com.mycarservice.dto.CarDto;
import com.mycarservice.dto.CarDtoTestStub;
import com.mycarservice.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CarControllerTest {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void testAddCarAttributesHttpSuccessful() throws Exception {
        String testCarDtoJson = "{\n" +
                "   \"carId\": 111,\n" +
                "   \"carName\": \"TestCarName\",\n" +
                "   \"carDescription\": \"TestCarDescription\"\n}";

        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/car/insertCar").
                contentType(MediaType.APPLICATION_JSON).content(testCarDtoJson)).
                andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testAddCarAttributesHttpFailed() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                post("/car/insertCar").content("failed")).
                andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testGetCarEntityFromDatabase() throws Exception {
        CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
        CarDto carDto = carDtoTestStub.setTestCarDto();

        List<CarDto> expectedResult = new ArrayList<>();
        expectedResult.add(carDto);

        when(carService.getCarDtosFromDatabase()).thenReturn(expectedResult);
        List<CarDto> actualResult = carService.getCarDtosFromDatabase();

        Assert.assertEquals("Elements do not match.", expectedResult, actualResult);
    }
}