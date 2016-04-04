package Threads;

import java.util.concurrent.Callable;

/**
 * Created by Vadim on 02.04.2016.
 */
public class SquareCalculator implements Callable<Integer> {
    private int[] values;

    public SquareCalculator(int[] values) {
        this.values = values;
    }

    @Override
    public Integer call() throws Exception {
        int result=0;
        for (int i = 0; i < values.length; i++) {
            result += values[i]*values[i];
        }
        return result;
    }
}
