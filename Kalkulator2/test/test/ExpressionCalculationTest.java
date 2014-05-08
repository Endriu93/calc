package test;

import junit.framework.TestCase;
import kalkulator.ExpressionCalculation;


public class ExpressionCalculationTest extends TestCase {
    private ExpressionCalculation Example1[];        // prawidłowe
    private ExpressionCalculation Example2[];    // Nieprawidłowe
    private String Expected[]; // Spodziewany wynik konwersji
    private double[] results;

    public void setUp() {
        Example1 = new ExpressionCalculation[2];
        Expected = new String[2];
        results = new double[2];

        Example2 = new ExpressionCalculation[2];

        Example1[0] = new ExpressionCalculation("3+8-(2+4)");
        Expected[0] = "3 + 8 - ( 2 + 4 )";
        results[0] = (double) 5;

        Example1[1] = new ExpressionCalculation("6*9");
        Expected[1] = "6 * 9";
        results[1] = (double) (6 * 9);
        // itd....

        // przykładowe błędy
        Example2[0] = new ExpressionCalculation("33xxx");
        Example2[1] = new ExpressionCalculation("noname4");

    }


    // sprawdza, czy rzuca wyjątki,jeżeli dostanie błedny String
    public void testConvertInputStringToRPNConvertable() {
        for (ExpressionCalculation item : Example2)
            try {
                String tmp = item.getRPNConvertableExp();
                System.out.println(tmp);

            } catch (Exception e)  //
            {
                System.out.println(e.getMessage());
                assertTrue(e instanceof IncorrectTextException);
            }

    }

    // sprawdza poprawne

    public void testConvertInputStringToRPNConvertable_2() {
        for (int i = 0; i < Example1.length; i++) {
            System.out.println(Example1[i].getRPNConvertableExp());
            System.out.println(Expected[i]);
            assertTrue(Example1[i].getRPNConvertableExp().equals(Expected[i]));
        }
    }


    public void testCalculate() {
        for (int i = 0; i < Example1.length; i++) {
            System.out.println(Example1[i].getResult() + " | " + (results[i]));
            assertEquals(Example1[i].getResult(), results[i]);
        }
    }


    public class IncorrectTextException extends RuntimeException {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        IncorrectTextException(String message) {
            super(message);
        }
    }


}
