package ua.goit.calculator;

import java.util.StringTokenizer;

/**
 * Created by Vadim on 03.05.2016.
 */
public class main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        String result = calculator.calculate("f 1 + 7");

        System.out.println("result = " + result);

        result = calculator.calculate("d 4 + 7");
        System.out.println("result = " + result);

        result = calculator.calculate("i 1 + 3");
        System.out.println("result = " + result);

        result = calculator.calculate("r 1 + 7");
        System.out.println("result = " + result);

        result = calculator.calculate("f 1 * 7");
        System.out.println("result = " + result);


        result = calculator.calculate("1 * 7");
        System.out.println("result = " + result);

    }
}
