package com.mycarservice.service;

import com.mycarservice.dto.CarDto;
import com.mycarservice.entity.CarEntity;
import com.mycarservice.repository.CarRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

//@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService = new CarService();

    @Mock
    private CarRepository carRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCarDtosFromDatabase() {
        List cars = new ArrayList();
        cars.add(new CarEntity(1, "TestCarName", "TestCarDescription"));
        Iterable <CarEntity> iterable = cars;
        Mockito.when(carRepository.findAll()).thenReturn(iterable);

        List<CarDto> carDtos = carService.getCarDtosFromDatabase();
        Assert.assertEquals(carDtos.size(), 1);
        Assert.assertEquals(carDtos.get(0).getCarName(), "TestCarName");
        Assert.assertEquals(carDtos.get(0).getCarDescription(), "TestCarDescription");
    }
}