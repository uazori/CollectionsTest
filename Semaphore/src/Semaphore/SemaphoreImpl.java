package Semaphore;

/**
 * Created by Vadim on 25.03.2016.
 */
public class SemaphoreImpl implements Semaphore {

    public SemaphoreImpl(int capacity) {

        this.capacity = capacity;
        permits = capacity;
        lock = new Object();
    }

    private int permits;
    private int capacity;

    public Object getLock() {
        return lock;
    }

    private Object lock;


    @Override
    public synchronized boolean acquire() {


        if (permits > 0) {
            permits--;
            return true;

        } else return false;

    }

    @Override
    public synchronized boolean acquire(int permits) {
        if (this.permits >= permits) {
            this.permits -= permits;
            return true;

        } else return false;
    }

    @Override
    public synchronized void release() {

        this.permits++;
synchronized (lock){
        lock.notify();
}
    }

    @Override
    public synchronized void release(int permits) {

        if ((this.permits + permits) <= capacity) {
            this.permits += permits;
        } else this.permits = capacity;

        synchronized (lock){

        lock.notifyAll();

        }
    }

    @Override
    public int getAvailablePermits() {
        return capacity-permits;
    }
}
