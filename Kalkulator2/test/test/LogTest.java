package test;

import junit.framework.TestCase;
import kalkulator.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;


public class LogTest extends TestCase {

    public void testLogin() throws Exception {
        assertTrue(Log.checkLogin("admin") && Log.checkPassword("admin"));
    }

    public void testWrite() throws Exception {
        String _testString = "testowy wpis"+System.currentTimeMillis()+"\n";

        Log.write(_testString);

        try
        {
            FileReader _test = new FileReader("logs.log");
            Scanner    _scanner = new Scanner(_test);

            String     _content = "";
            while(_scanner.hasNext())
            {
                _content += _scanner.nextLine();
            }
            _content += _scanner.nextLine();

            assertTrue(_content.indexOf(_testString) >= 0);
        }
        catch(Exception e)
        {

        }

    }

    public void testRead(){
        try {
            FileReader reader = new FileReader("logs.log");
            BufferedReader buffer = new BufferedReader(reader);
            String s, _cont = "";
            int i = 1;
            while ((s = buffer.readLine()) != null) {
                _cont += i++ + ": " + s;
            }
            reader.close();

            assertEquals(_cont, Log.read());
        }
        catch(Exception e)
        {

        }
    }

    public void testClear()
    {

    }

}