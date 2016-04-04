import SquareSum.SquareSumImpl;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        final int CAPACITY = 1000;
        final int THREADS = 10;
        int[] values = new int[CAPACITY];

        for (int i = 0; i < CAPACITY; i++) {
            values[i] = random.nextInt(100);
        }

        SquareSumImpl squareSum = new SquareSumImpl();



            System.out.println("result = " + squareSum.getSquareSum( values, THREADS) );



    }
}
