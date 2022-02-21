package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.junit.*;

public class RangeCombineIgnoringNaN {

    @Test
    public void testBothNull () {
        Range result = Range.combineIgnoringNaN (null, null);
        assertEquals (result, null, 0);
    }

    @Test
    public void test1stNull () {
        Range param = new Range (1, 14);
        Range result = Range.combineIgnoringNaN (param, null);
        assertEquals (result, param, 0);
    }

    @Test
    public void test2ndNull () {
        Range param = new Range (1, 14);
        Range result = Range.combineIgnoringNaN (null, param);
        assertEquals (result, param, 0);
    }

    @Test
    public void testNaN () {
        Range param1 = new Range (1, 14);
        Range param2 = new Range (Double.Nan, 3);
        Range result = Range.combineIgnoringNaN (param1, param2);
        assertEquals (result, null, 0);
    }
}