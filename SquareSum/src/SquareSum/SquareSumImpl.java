package SquareSum;

import Threads.SquareCalculatorCall;

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

        final Phaser phaser = new Phaser(numberOfThreads);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        Collection<Callable<Integer>> calculateSquareSummThreads = new ArrayList<>();

        long result = 0;


        if (numberOfThreads < 1) {
            numberOfThreads = 1;
        }


        calculateSquareSummThreads = creteCallableArray(values,numberOfThreads,phaser);


        try {
            List<Future<Integer>> resultArray = executor.invokeAll(calculateSquareSummThreads);

            for (Future<Integer> future : resultArray) {

               result += future.get();

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        System.out.println("registered:" + phaser.getRegisteredParties() +
                            " unArrived:" + phaser.getUnarrivedParties()+
                            " arrived:" + phaser.getArrivedParties()+
                             " phase:" + phaser.getPhase());



        return result;
    }

    public Collection<Callable<Integer>> creteCallableArray(int[] values,int numberOfThreads,Phaser phaser){
        Collection<Callable<Integer>> CalculateSquareSummThreads = new ArrayList<>();

        int delta = values.length / numberOfThreads + 1;

        int start = 0;

        while (start < values.length) {

            if ((values.length - start) < delta) {
                delta = values.length - start;
            }

            int[] arrayForThread = new int[delta];

            System.arraycopy(values, start, arrayForThread, 0, delta);

            System.out.println(Arrays.toString(arrayForThread));

            Callable<Integer> CalculateSquareThread = new SquareCalculatorCall(arrayForThread,phaser);

            CalculateSquareSummThreads.add(CalculateSquareThread);

            start += delta;

        }

        return CalculateSquareSummThreads;
    }


}
