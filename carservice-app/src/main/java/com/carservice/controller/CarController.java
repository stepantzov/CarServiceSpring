package com.carservice.controller;

import com.carservice.dto.CarDto;
import com.carservice.service.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET, value = "/controllerOutput")
    public String doOutput() {
        return "CarController output.";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertCar")
    @ApiOperation(value = "Create a new Car Instance.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "New Car instance added successfully."),
            @ApiResponse(code = 500, message = "Failed to add new Car instance.")})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "New Car instance added successfully.")
    public ResponseEntity addCarAttributes(@RequestBody CarDto carDto) {
        try {
            carService.addCarInstance(carDto);

            return new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getStoredCarData")
    @ApiOperation(value = "Get List of Car instances from db.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Car ."),
            @ApiResponse(code = 500, message = "Failed to receive car instance from db.")})
    public ResponseEntity getCarEntityFromDatabase() {

        return new ResponseEntity(carService.getCarDtosFromDatabase(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateCar")
    @ApiOperation(value = "Update existing car instance.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Car instance updated successfully."),
            @ApiResponse(code = 500, message = "Failed to update Car instance."),
            @ApiResponse(code = 404, message = "Car instance with such ID not found.")})
    @ResponseBody
    public ResponseEntity updateCarInstance(@RequestBody CarDto carDto) {
        try {
            if (carService.verifyCarInstancePresent(carDto) == true) {
                carService.addCarInstance(carDto);
                return new ResponseEntity(carService.getExactCarDto(carDto.getCarId()), HttpStatus.CREATED);
            } else
                return new ResponseEntity("Entity not found.", HttpStatus.NOT_FOUND);


        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}