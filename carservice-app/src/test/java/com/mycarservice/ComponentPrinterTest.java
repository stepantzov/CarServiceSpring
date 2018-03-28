package com.mycarservice;

import junit.framework.TestCase;
import mycarservice.components.ComponentPrinter;

public class ComponentPrinterTest extends TestCase {
    public void testComponentPrinter(){
        assertEquals("Car web service component.", ComponentPrinter.printComponent());
    }
}