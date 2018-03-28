package com.mycarservice.components;

import junit.framework.TestCase;

public class ComponentPrinterTest extends TestCase {
    public void testComponentPrinter(){
        assertEquals("Car web service component.", ComponentPrinter.printComponent());
    }
}