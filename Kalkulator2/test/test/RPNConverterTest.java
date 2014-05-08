package test;

/**
 * @author Endriu
 *
 */

import java.util.Arrays;
import java.util.Collection;

import kalkulator.RPNConverter;
import junit.framework.*;

public class RPNConverterTest extends TestCase {


    private RPNConverter example;
    private String Expected; // Spodziewany wynik konwersji


    public void setUp(String ToConverting, String Converted) {


    }

    public static Collection<String[]> data() {
        String[][] database = {{"3 + 4 * 2 / ( 1 - 5 ) ^ 2", "3 4 2 * 1 5 - 2 ^ / +"}
                , {"5 * 8 ^ 3 ( 6 + 8 ) - 32", "5 8 3 6 8 + ^ * 32 -"}
                , {"log ( 5 ) - abs ( -30 )", "5 log -30 abs -"}
        };
        return Arrays.asList(database);
    }


    public void testConvertToRPN() {

        for(String[] exp : data())
        {
            example = new RPNConverter(exp[0]);

            assertEquals(exp[1].trim(), example.convertToRPN().trim());
        }
    }

}
