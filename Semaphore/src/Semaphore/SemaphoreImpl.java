package Semaphore;

/**
 * Created by Vadim on 25.03.2016.
 */
public class SemaphoreImpl implements Semaphore {

    private volatile int permits;
    private int capacity;


    public SemaphoreImpl(int capacity) {

        this.capacity = capacity;
        permits = capacity;

    }


    @Override
    public synchronized void acquire() throws InterruptedException {


        if (permits > 0) {
            permits--;


        } else {
            while (permits < 1) wait();
        }

    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (this.permits >= permits) {
            this.permits -= permits;

        } else {
            while (this.permits < permits) wait();
        }
    }

    @Override
    public synchronized void release() {

        if ((this.permits + 1) <= capacity) {
            this.permits++;
        }


    }

    @Override
    public synchronized void release(int permits) {

        if ((this.permits + permits) <= capacity) {
            this.permits += permits;
        } else this.permits = capacity;


    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
