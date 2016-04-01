package Semaphore;

/**
 * Created by Vadim on 25.03.2016.
 */
public class SemaphoreImpl implements Semaphore {

    private volatile int permits;
    private int capacity;
    private Object lock;



    public SemaphoreImpl(int capacity) {

        this.capacity = capacity;
        permits = capacity;
        lock = new Object();

    }


    @Override
    public synchronized void acquire() throws InterruptedException {


        if (permits > 0) {
            permits--;


        } else {
             synchronized (lock) {lock.wait();}
        }

    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (this.permits >= permits) {
            this.permits -= permits;

        } else {
            synchronized (lock) {lock.wait();}
        }

    }

    @Override
    public synchronized void release() {

        if ((this.permits + 1) <= capacity) {
            this.permits++;
            synchronized (lock) {lock.notify();}
        }



    }

    @Override
    public synchronized void release(int permits) {

        if ((this.permits + permits) <= capacity) {
            this.permits += permits;
            synchronized (lock) {lock.notifyAll();}
        } else {
            if (this.permits < capacity){
                this.permits = capacity;
                synchronized (lock) {lock.notifyAll();}
            }
        }



    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
