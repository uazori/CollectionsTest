import SquareSum.SquareSumImpl;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        final int CAPACITY = 100;
        int[] values = new int[CAPACITY];// = {1,2,3,4,5};

        for (int i = 0; i < CAPACITY; i++) {
            values[i] = i+1;
        }

        SquareSumImpl squareSum = new SquareSumImpl();



            System.out.println("result = " + squareSum.getSquareSum( values, 3) );



    }
}
