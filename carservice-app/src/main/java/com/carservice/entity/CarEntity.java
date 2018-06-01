package com.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarEntity {
    @Id
    private int carId;
    private String carName;
    private String carDescription;

    public CarEntity() {
    }

    public CarEntity(int carId, String carName, String carDescription) {
        this.carId = carId;
        this.carName = carName;
        this.carDescription = carDescription;
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

    public void setCarName(String carEntityName) {
        this.carName = carEntityName;
    }
}