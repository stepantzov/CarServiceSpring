package com.mycarservice.dto;

import com.mycarservice.entity.CarEntity;

public class CarDto {
    private static int carId;
    private static String carName;
    private static String carDescription;

    public CarDto() {
    }

    public CarDto(int carId, String carName, String carDescription) {
        this.carId = carId;
        this.carDescription = carDescription;
        this.carName = carName;
    }

    public static int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public static String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public static String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public static CarEntity convertToEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarEntityId(getCarId());
        carEntity.setCarEntityDescription(getCarDescription());
        carEntity.setEntityCarName(getCarName());

        return carEntity;
    }
}