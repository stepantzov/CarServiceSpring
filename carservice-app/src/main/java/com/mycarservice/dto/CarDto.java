package com.mycarservice.dto;

public class CarDto {
    private int carId;
    private String carName;
    private String carDescription;

    public CarDto() {
    }

    public CarDto(int carId, String carName, String carDescription) {
        this.carId = carId;
        this.carDescription = carDescription;
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}