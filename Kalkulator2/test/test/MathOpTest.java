/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import junit.framework.TestCase;
import kalkulator.MathOp;

/**
 * @author Bartosz
 */
public class MathOpTest extends TestCase {

    public MathOpTest(String testName) {
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
     * Test of Add method, of class MathOp.
     */
    public void testAdd() {
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E300, -1.1E300},
                                    {-3., 2.5, 0., 0., 1., -2., 3., 3.7, 1.1E300, -1.1E300},
                                    {-6., 0., -1., 0., 2., 0., 6.4, 7.2, 2.2E300, -2.2E300}};

        for (int i = 0; i < 10; i++)
        {
            assertEquals(n[2][i], MathOp.Add(n[0][i], n[1][i]), 0.001);
        }
    }

    /**
     * Test of Minus method, of class MathOp.
     */
    public void testMinus() {
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E300, -1.1E300},
                                        {-3., 2.5, 0., 0., 1., -2., 3., 3.7, 1.1E300, 1.1E300},
                                        {0., -5., -1., 0., 0., 4., 0.4, -0.2, 0., -2.2E300}};

        for (int i = 0; i < 10; i++)
        {
            assertEquals(n[2][i], MathOp.Minus(n[0][i], n[1][i]), 0.001);
        }
    }

    /**
     * Test of Multiply method, of class MathOp.
     */
    public void testMultiply() {
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E100, -1.1E100},
                                        {-3., 2.5, 0., 0., 1., -2., 3., 3.7, 1.1E100, 1.1E100},
                                        {9., -6.25, 0., 0., 1., -4., 10.2, 12.95, 1.21E200, -1.21E200}};

        for (int i = 0; i < 10; i++)
        {
            assertEquals(n[2][i], MathOp.Multiply(n[0][i], n[1][i]), 0.001);
        }
    }

    /**
     * Test of Divide method, of class MathOp.
     */
    public void testDivide() {
        Double[][] n = new Double[][]{{-3., -2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E100, -1.1E100},
                {-3., 2.5, 0., 0., 1., -2., 3., 3.7, 1.1E100, 1.1E100},
                {1., -1., 0., 0., 1., -1., 1.133333, 0.945945, 1., -1.}};

        for (int i = 0; i < 10; i++)
        {
            try {
                assertEquals(n[2][i], MathOp.Divide(n[0][i], n[1][i]), 0.001);
            }
            catch (Exception e) {
                assertTrue(e instanceof kalkulator.DividedByZeroException);
            }
        }
    }

    /**
     * Test of Power method, of class MathOp.
     */
    public void testPower() {
        Double[][] n = new Double[][]{{-3., 2.5, -1., 0., 1., 2., 3.4, 3.5, 1.1E100, -1.1E100},
                                    {-3., 2.5, 0., 0., 1., -2., 3., 3.7, -1.1E100, -1.1E100},
                                    {-0.0370370, 9.88212, 1., 0., 1., 0.25, 39.304, 103.05089, 0., 0.}};
        for (int i = 0; i < 10; i++)
        {
            try
            {
                assertEquals(n[2][i], MathOp.Power(n[0][i], n[1][i]), 0.001);
            }
            catch (Exception e) {
                assertTrue(e instanceof kalkulator.PoweredZeroByZeroException);
            }
        }
    }
}
