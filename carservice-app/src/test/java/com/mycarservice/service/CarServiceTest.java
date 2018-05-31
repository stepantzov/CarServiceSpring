package com.mycarservice.service;

import com.mycarservice.dto.CarDto;
import com.mycarservice.dto.CarDtoTestStub;
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
        Iterable<CarEntity> iterable = cars;
        Mockito.when(carRepository.findAll()).thenReturn(iterable);

        List<CarDto> carDtos = carService.getCarDtosFromDatabase();
        Assert.assertEquals(carDtos.size(), 1);
        Assert.assertEquals(carDtos.get(0).getCarName(), "TestCarName");
        Assert.assertEquals(carDtos.get(0).getCarDescription(), "TestCarDescription");
    }

    @Test
    public void testAddCarInstance() {
        CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
        CarDto carDto = carDtoTestStub.setTestCarDto();
        List<CarDto> carDtoList = new ArrayList<>();

        when(carRepository.save(any(CarEntity.class))).thenReturn(new CarEntity());
        carService.addCarInstance(carDto);

        verify(carRepository, times(1)).save(any(CarEntity.class));
    }

    @Test(expected = Exception.class)
    public void testAddCarInstanceThrowException() {
        CarDtoTestStub carDtoTestStub = new CarDtoTestStub();
        CarDto carDto = carDtoTestStub.setTestCarDto();

        when(carRepository.save(any(CarEntity.class))).thenThrow(Exception.class);

        try {
            carService.addCarInstance(carDto);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
}