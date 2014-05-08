package kalkulator;

import java.util.Scanner;

public class CalcTest {
    private static void wyswietlMenu() {
        System.out.println("funkcje: abs(),log(),fact() ; login - zaloguj sie jako admin(przeglad,usuwanie logow) ;  q - quit");
        System.out.println("Wpisz wyrazenie do obliczenia:");
    }

    private static void run() {


        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                wyswietlMenu();
                String expression = in.nextLine();
                if (expression.equals("q")) {
                    System.exit(0);
                }
                if (expression.equals("login")) {
                    Log.login();
                } else {
                    ExpressionCalculation ec = new ExpressionCalculation(expression);
                    ec.doCalc();
                    Log.write("wpisane wyrażenie: " + expression);
                    if (ec.isValid()) {
                        System.out.println(ec.getExpression() + " = " + ec.getResult());
                        System.out.printf("operacje wykonano w: %f\n", ec.getOperationTime());
                        System.out.println(" sekundy");
                        Log.write(" obliczono w czasie: " + ec.getOperationTime() + " sekundy \r\n");
                    } else {
                        System.out.println("Wprowadzono zle wyrazenie!");
                    }
                }
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) {

        run();
    }
}
