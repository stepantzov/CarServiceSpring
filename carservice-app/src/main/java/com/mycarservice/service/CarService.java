package com.mycarservice.service;

import com.mycarservice.dto.CarDto;
import com.mycarservice.entity.CarEntity;
import com.mycarservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static List<CarDto> carInstances = new ArrayList<>(Arrays.asList(
            new CarDto(2101, "VAZ", "Lada 2101")));

    public List<CarDto> getCarInstances() {
        return carInstances;
    }

    public void addCarInstance(CarDto carDto) {
        carInstances.add(carDto);
    }

    public static List<CarEntity> getEntitiesListFromDto() {
        CarEntity carEntity = CarDto.convertToEntity();

        List<CarEntity> carEntities = new ArrayList<>(Arrays.asList(
                new CarEntity(carEntity.getCarEntityId(), carEntity.getCarEntityDescription(),
                        carEntity.getEntityCarName())));

        return carEntities;
    }

    public List<CarEntity> getCarEntitiesFromDatabase() {
        List<CarEntity> carEntities = new ArrayList<>();
        carRepository.findAll().forEach(carEntities::add);

        return carEntities;
    }

    public void addCarEntityToDatabase() {
        carRepository.saveAll(getEntitiesListFromDto());
    }
}