package com.mycarservice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MyCarServiceAppTest extends TestCase {

    public MyCarServiceAppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MyCarServiceAppTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }
}