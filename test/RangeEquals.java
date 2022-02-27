package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.*;

public class RangeEquals {
    private static Range range;

    @BeforeClass
    public static void setup () {
        range = new Range (2, 10);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testEquNull () {
        Range comp = null;
        boolean result = range.equals(null);
        assertTrue (result);
    }

    @Test
    public void testNonEquNull () {
        boolean result = range.equals (null);
        assertFalse (result);
    }

    @Test
    public void testEquRange () {
        Range param = new Range (2, 10);
        boolean result = range.equals (param);
        assertTrue(result);
    }

    @Test
    public void testNonEquRange () {
        Range param = new Range (1, 2);
        boolean result = range.equals (param);
        assertFalse (result);
    }

    @Test
    public void testNonEquNonRange () {
        String param = "Hello";
        boolean result = range.equals (param);
        assertFalse (result);
    }
}