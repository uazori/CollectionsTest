package SquareSum;

import Threads.SquareCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Vadim on 02.04.2016.
 */
public class SquareSumImpl implements SquareSum {
    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        Collection<Callable<Integer>> SquareThreads = new ArrayList<>();

        int result = 0;


        if (numberOfThreads < 1) {
            numberOfThreads = 1;
        }

        int delta = values.length / numberOfThreads + 1;

        int start = 0;

        while (start < values.length) {

            if ((values.length - start) < delta) {
                delta = values.length - start;
            }

            int[] arrayForThread = new int[delta];

            System.arraycopy(values, start, arrayForThread, 0, delta);

            System.out.println(Arrays.toString(arrayForThread));

            Callable<Integer> CalculateSquareThread = new SquareCalculator(arrayForThread);

            SquareThreads.add(CalculateSquareThread);

            start += delta;

        }




        try {
            List<Future<Integer>> resultArray = executor.invokeAll(SquareThreads);
            for (Future<Integer> future : resultArray) {
               result += future.get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return result;
    }



}
