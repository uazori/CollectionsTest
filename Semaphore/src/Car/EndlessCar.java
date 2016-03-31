package Car;

import Semaphore.SemaphoreImpl;

/**
 * Created by Vadim on 26.03.2016.
 */
public class EndlessCar implements Runnable{
    private SemaphoreImpl semaphore;

    public EndlessCar(SemaphoreImpl semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "Waiting");
            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() + " working ! ");

            synchronized (this) {
                int summ=0;
                while (summ<5){
                    summ=1;
                    summ += 1;
                }
            }

            System.out.println(Thread.currentThread().getName() + " end !");

            semaphore.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }







    }
}
