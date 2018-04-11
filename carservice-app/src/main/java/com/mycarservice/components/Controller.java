package com.mycarservice.components;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping ("/controllerOutput")
    public String doOutput(){
        return "Controller output.";
    }
}