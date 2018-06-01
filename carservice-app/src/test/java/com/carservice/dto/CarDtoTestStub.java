package com.carservice.dto;

public class CarDtoTestStub {

    public CarDto getTestCarDto() {
        CarDto carDto = new CarDto(111, "TestCarName", "TestCarDescription");

        return carDto;
    }
}