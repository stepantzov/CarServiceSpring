package com.carservice.service;

import com.carservice.dto.CarDto;
import com.carservice.entity.CarEntity;
import com.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ConverterUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCarInstance(CarDto carDto) {
        CarEntity carEntity = ConverterUtils.convertDtoToEntity(carDto);
        carRepository.save(carEntity);
}

    public List<CarDto> getCarDtosFromDatabase() {
        List<CarDto> carDtoList = new ArrayList<>();
        Iterable<CarEntity> carEntities = carRepository.findAll();
        carEntities.forEach(carEntity -> {
            CarDto carDto = ConverterUtils.convertToDto(carEntity);
            carDtoList.add(carDto);
        });

        return carDtoList;
    }
}