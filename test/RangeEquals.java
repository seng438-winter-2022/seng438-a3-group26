package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.junit.*;

public class RangeEquals {
    private static Range range;

    @BeforeClass
    public static void setup () {
        range = new Range (10, 2);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testEquNull () {
        Range comp = null;
        boolean result = Range.equals(null);
        assertTrue (result);
    }

    @Test
    public void testNonEquNull () {
        boolean result = Range.equals (null);
        assertFalse (result);
    }

    @Test
    public void testEquRange () {
        Range param = new Range (10, 2);
        boolean result = Range.equals (param);
        assertTrue(result);
    }

    @Test
    public void testNonEquRange () {
        Range param = new Range (1, 2);
        boolean result = Range.equals (param);
        assertFalse (result);
    }

    @Test
    public void testNonEquNonRange () {
        String param = "Hello";
        boolean result = Range.equals (param);
        assertFalse (result);
    }
}