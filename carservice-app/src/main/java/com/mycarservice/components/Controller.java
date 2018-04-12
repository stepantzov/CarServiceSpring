package com.mycarservice.components;

import com.mycarservice.dto.CarDto;
import com.mycarservice.services.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CarService carService;

    @RequestMapping("/controllerOutput")
    public String doOutput() {
        return "Controller output.";
    }

    @RequestMapping("/getCarAttributes")
    public List<CarDto> getCarAttributes() {
        return carService.getCarInstances();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getCarAttributes")
    @ApiOperation(value = "Create a new Car Instance.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "New Car instance added successfully."),
            @ApiResponse(code = 500, message = "Failed to add new Car instance.")})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "New Car instance added successfully.")
    public void addCarAttributes(@RequestBody CarDto carDto) {
        carService.addCarInstance(carDto);
    }
}