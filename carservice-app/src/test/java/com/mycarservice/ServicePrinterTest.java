package com.mycarservice;

import junit.framework.TestCase;
import mycarservice.services.ServicePrinter;

public class ServicePrinterTest extends TestCase {
    public void testServicePrinter(){
        assertEquals("Car web service.", ServicePrinter.printService());
    }
}