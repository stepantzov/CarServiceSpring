package com.mycarservice.services;

import junit.framework.TestCase;

public class ServicePrinterTest extends TestCase {
    public void testServicePrinter(){
        assertEquals("Car web service.", ServicePrinter.printService());
    }
}