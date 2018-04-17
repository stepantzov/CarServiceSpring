package com.mycarservice.entity;

import com.mycarservice.dto.CarDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarEntity {
    @Id
    private int carEntityId;
    private String carEntityName;
    private String carEntityDescription;

    public CarEntity() {
    }

    public CarEntity(int carEntityId, String carEntityName, String carEntityDescription) {
        this.carEntityId = carEntityId;
        this.carEntityName = carEntityName;
        this.carEntityDescription = carEntityDescription;
    }

    public int getCarEntityId() {
        return carEntityId;
    }

    public void setCarEntityId(int carEntityId) {
        this.carEntityId = carEntityId;
    }

    public String getCarEntityDescription() {
        return carEntityDescription;
    }

    public void setCarEntityDescription(String carEntityDescription) {
        this.carEntityDescription = carEntityDescription;
    }

    public String getEntityCarName() {
        return carEntityName;
    }

    public void setEntityCarName(String carEntityName) {
        this.carEntityName = carEntityName;
    }

    public CarDto convertToDto() {
        CarDto carDto = new CarDto();
        carDto.setCarId(carEntityId);
        carDto.setCarDescription(carEntityDescription);
        carDto.setCarName(carEntityName);

        return carDto;
    }
}