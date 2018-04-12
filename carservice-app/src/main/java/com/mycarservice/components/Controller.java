package com.mycarservice.components;

import com.mycarservice.dto.CarDto;
import com.mycarservice.services.CarService;
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
    @ResponseStatus(value = HttpStatus.OK)
    public void addCarAttributes(@RequestBody CarDto carDto) {
        carService.addCarInstance(carDto);
    }
}