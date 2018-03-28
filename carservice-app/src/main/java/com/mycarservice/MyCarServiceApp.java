package mycarservice;

import mycarservice.components.ComponentPrinter;
import mycarservice.services.ServicePrinter;

public class MyCarServiceApp {
    public static void main(String[] args) {
        ServicePrinter.printService();
        ComponentPrinter.printComponent();
    }
}