package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

/**
 * Created by Vadim on 02.04.2016.
 */
public class SquareCalculatorCall implements Callable<Integer> {
    private int[] values;
    private Phaser phaser;

    public SquareCalculatorCall(int[] values, Phaser phaser) {
        this.values = values;
        this.phaser = phaser;
    }

    @Override
    public Integer call() throws Exception {


        System.out.println(Thread.currentThread().getName());
        System.out.println("registered:" + phaser.getRegisteredParties() +
                " unArrived:" + phaser.getUnarrivedParties()+
                " arrived:" + phaser.getArrivedParties()+
                " phase:" + phaser.getPhase());
        System.out.println();



        int result=0;

        for (int i = 0; i < values.length; i++) {

            result += values[i]*values[i];
        }
        phaser.arriveAndAwaitAdvance();

        return result;
    }
}
