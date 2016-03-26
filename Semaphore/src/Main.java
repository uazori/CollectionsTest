import Semaphore.SemaphoreImpl;
import Semaphore.Semaphore;
import Car.Car;

public class Main {

    public static void main(String[] args) {
        SemaphoreImpl semaphore = new SemaphoreImpl(1);
        System.out.println("Hello World!");

        for (int i = 0; i < 100; i++) {
            new Thread(new Car(semaphore)).start();
        }



    }
}
