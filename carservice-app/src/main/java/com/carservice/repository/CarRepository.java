package com.carservice.repository;

import com.carservice.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarEntity, Integer> {
}