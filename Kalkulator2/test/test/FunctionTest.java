/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import junit.framework.TestCase;
import kalkulator.*;

/**
 * @author Bartosz
 */
public class FunctionTest extends TestCase {

    public FunctionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of Log method, of class Function.
     */
    public void testLog() {
        System.out.println("Log");
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E100, -1.1E100},
                {1., -1., 0., 0., 0., 0.69314, 1.2237, 1.25276, 230.35282, -1.}};
        for (int i = 0; i < 10; i++) {
            try {
                Double x = n[0][i];
                double expResult = n[1][i];
                double result = Function.Log(x);
                assertEquals(expResult, result, 0.001);
            } catch (Exception e) {
                assertTrue(e instanceof NegativeLogException);
            }
        }
    }

    /**
     * Test of Sqrt method, of class Function.
     */
    public void testSqrt() {
        System.out.println("Sqrt");
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 4., 1.1E100},
                                      {Double.NaN, Double.NaN, Double.NaN, 0., 1., 1.4142135623730951, 1.8439088914585775, 1.8708286933869707, 2., 1.0488088481701515E50}};
        for (int i = 0; i < 10; i++) {
            assertEquals(n[1][i], Function.Sqrt(n[0][i]));
        }
    }

    /**
     * Test of Abs method, of class Function.
     */
    public void testAbs() {
        System.out.println("Abs");
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E100, -1.1E100},
                                      {3., 2.5, 1., 0., 1., 2., 3.4, 3.5, 1.1E100, 1.1E100}};
        for (int i = 0; i < 10; i++) {
            Double x = n[0][i];
            double expResult = n[1][i];
            double result = Function.Abs(x);
            assertEquals(expResult, result, 0.001);
        }
    }

    /**
     * Test of Fact method, of class Function.
     */
    public void testFact() {
        System.out.println("Fact");
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3., 3.5, 10., 100.},
                                      {1., 1., 1., 1., 1., 2., 6., 13.125, 3628800., 9.33262154439441E157}};
        for (int i = 0; i < 10; i++) {
            try {
                Double x = n[0][i];
                double expResult = n[1][i];
                double result = Function.Fact(x);
                assertEquals(expResult, result, 0.001);
            } catch (Exception e) {
            }
        }
    }
}
