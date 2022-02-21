package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeExpand {
    private static Range range;
    
    @BeforeClass
    public static void setup () {
        range = new Range (3, 4);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testLowerMargin () {
        Range result = Range.expand (range, 1.2, 0);
        Range comp = new Range (1.8, 4);
        assertEquals(result, comp, 0);
    }

    @Test
    public void testUpperMargin () {
        Range result = Range.expand (range, 0, 0.8);
        Range comp = new Range (3, 4.8);
        assertEquals(result, comp, 0);
    }

    @Test
    public void testBothZero () {
        Range result = Range.expand (range, 0, 0);
        assertEquals (result, range, 0);
    }

    @Test
    public void testNull () {
        boolean thrown = false;
        try {
            Range.expand (null, 0, 0);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue (thrown);
    }

    @Test
    public void testNegativeLower () {
        Range result = Range.expand (range, - 0.1, 0);
        Range comp = new Range (3.1, 4);
        assertEquals (result, comp, 0);
    }

    @Test
    public void testNegativeUppper () {
        Range result = Range.expand (range, 0, -0.1);
        Range comp = new Range (3, 3.9);
        assertEquals (result, comp, 0);
    }

    @Test
    public void testOverlap () {
        Range result = Range.expand (range, -3, 0);
        Range comp = new Range (4, 6);
        assertEquals (result, comp);
    }
}