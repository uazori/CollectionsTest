import Semaphore.SemaphoreImpl;
import Semaphore.Semaphore;
import Car.Car;
import Car.EndlessCar;

import java.util.Date;
import java.util.Timer;

public class Main {




    public static void main(String[] args) {




    test1();
    test2();

    }

    public static void test1(){
        System.out.println("Average test !!!");

        SemaphoreImpl semaphore = new SemaphoreImpl(10);

        for (int i = 0; i < 100; i++) {
            new Thread(new Car(semaphore,25000)).start();
        }


    }

    public static void test2(){


    }
}
