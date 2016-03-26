package Car;

import Semaphore.SemaphoreImpl;

/**
 * Created by Vadim on 25.03.2016.
 */
public class Car implements Runnable {
    private SemaphoreImpl semaphore;




    public Car(SemaphoreImpl semaphore) {
        this.semaphore = semaphore;

    }

    @Override
    public void run() {
        while (!semaphore.acquire()) {
            System.out.println(Thread.currentThread().getName() + " waiting");
            Object lock = semaphore.getLock();
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (this) {
            int summ=0;
            for (int i = 0; i < 25000; i++) {
                summ += i;
            }
            System.out.println(Thread.currentThread().getName() + " working ! ");
        }

        System.out.println(Thread.currentThread().getName() + " end !");
        semaphore.release();

    }
}
