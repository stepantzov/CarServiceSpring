package com.mycarservice.controller;

import com.mycarservice.repository.CarRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CarControllerTest {

    @Autowired
    private CarRepository carRepository;

   /* @Before
    public void preconditions() {
        CarService carService = new CarService(carRepository);
        CarDtoTestStub carDto = new CarDtoTestStub();

        carService.addCarInstance(carDto.setTestCarDto());
    }*/

    @Test
    public void testCarController(){
        CarController carController = new CarController();
        System.out.println(carController.getCarEntityFromDatabase());

        assertEquals(carController.getCarEntityFromDatabase(), 1);
    }
}