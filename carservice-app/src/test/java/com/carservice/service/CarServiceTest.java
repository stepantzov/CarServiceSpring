package com.carservice.service;

import com.carservice.dto.CarDto;
import com.carservice.dto.CarDtoTestStub;
import com.carservice.entity.CarEntity;
import com.carservice.repository.CarRepository;
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

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService = new CarService();

    @Mock
    private CarRepository carRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCarDtosFromDatabase() {
        List<CarEntity> cars = new ArrayList<>();
        cars.add(new CarEntity(1, "TestCarName", "TestCarDescription"));
        Mockito.when(carRepository.findAll()).thenReturn(cars);

        List<CarDto> carDtos = carService.getCarDtosFromDatabase();
        Assert.assertEquals(carDtos.size(), 1);
        Assert.assertEquals(carDtos.get(0).getCarName(), "TestCarName");
        Assert.assertEquals(carDtos.get(0).getCarDescription(), "TestCarDescription");
    }

    @Test
    public void testAddCarInstance() {
        CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
        CarDto carDto = carDtoTestStub.getTestCarDto();

        when(carRepository.save(any(CarEntity.class))).thenReturn(new CarEntity());
        carService.addCarInstance(carDto);

        verify(carRepository, times(1)).save(any(CarEntity.class));
    }

    @Test()
    public void testAddCarInstanceThrowException() {
        CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
        CarDto carDto = carDtoTestStub.getTestCarDto();

        when(carRepository.save(any(CarEntity.class))).thenThrow(RuntimeException.class);

        try {
            carService.addCarInstance(carDto);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
}