package com.mycarservice;

import com.mycarservice.components.ComponentPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyCarServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(MyCarServiceApp.class, args);
        ComponentPrinter.printComponent();
    }
}