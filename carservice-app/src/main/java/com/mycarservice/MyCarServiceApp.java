package com.mycarservice;

import com.mycarservice.components.ComponentPrinter;
import com.mycarservice.services.ServicePrinter;

public class MyCarServiceApp {
    public static void main(String[] args) {
        ServicePrinter.printService();
        ComponentPrinter.printComponent();
    }
}