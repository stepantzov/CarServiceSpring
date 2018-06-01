package utils;

import com.carservice.dto.CarDto;
import com.carservice.entity.CarEntity;

public class ConverterUtils {
    public static CarEntity convertDtoToEntity(CarDto carDto) {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(carDto.getCarId());
        carEntity.setCarDescription(carDto.getCarDescription());
        carEntity.setCarName(carDto.getCarName());

        return carEntity;
    }

    public static CarDto convertToDto(CarEntity carEntity) {
        CarDto carDto = new CarDto();
        carDto.setCarId(carEntity.getCarId());
        carDto.setCarDescription(carEntity.getCarDescription());
        carDto.setCarName(carEntity.getCarName());

        return carDto;
    }
}