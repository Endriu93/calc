/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Szymon
 */
public class Log {
    //private FileReader reader;
    //private FileWriter writer;
    static private final String login = "admin";
    static private final String pass = "admin";

    private Log() {
    }

    public static boolean checkLogin(String _login)
    {
        return _login.trim().equals(login.trim());
    }

    public static boolean checkPassword(String _pass)
    {
        return _pass.trim().equals(pass.trim());
    }

    static public void login() {
        Scanner in = new Scanner(System.in);
        String tempLogin;
        System.out.println("podaj login: ");
        tempLogin = in.nextLine();
        while (!checkLogin(tempLogin)) {
            System.out.println("bledny login, podaj nowy('logout' wraca do poprzedniego menu): ");
            tempLogin = in.nextLine();
            if (tempLogin.equals("logout"))
                return;
        }
        System.out.println("podaj haslo: ");
        tempLogin = in.nextLine();
        while (!checkPassword(tempLogin)) {
            System.out.println("bledne haslo, podaj nowe('logout' wraca do poprzedniego menu): ");
            tempLogin = in.nextLine();
            if (tempLogin.equals("logout"))
                return;
        }
        System.out.println("Witamy krola administratora! Co chcesz zrobic: read - pokazuje loga, clear - usuwa loga, logout - powrot do poprzedniego menu");
        tempLogin = in.nextLine();
        while (!tempLogin.equals("logout")) {
            if (tempLogin.equals("read"))
                Log.read();
            if (tempLogin.equals("clear"))
                Log.clear();
            System.out.println("read - pokazuje loga, clear - usuwa loga, logout - powrot do poprzedniego menu");
            tempLogin = in.nextLine();
        }
    }

    static public void write(String toWrite) {
        try {
            FileWriter writer = new FileWriter("logs.log", true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println("blad zapisu do pliku!");
        }
    }

    static public String read() {
        try {
            FileReader reader = new FileReader("logs.log");
            BufferedReader buffer = new BufferedReader(reader);
            String s, _cont = "";
            int i = 1;
            while ((s = buffer.readLine()) != null) {

                _cont += i+": "+s;
                System.out.println(i + ": " + s);
                ++i;
            }
            reader.close();

            return _cont;
        } catch (IOException e) {
            System.out.println("blad odczytu pliku!");
            return "";
        }
    }

    static public void clear() {
        try {
            File file = new File("logs.log");
            file.delete();
            System.out.println("usunieto logi!");
        } catch (Exception e) {
            System.out.println("blad czyszczenia pliku!");
        }
    }


}
