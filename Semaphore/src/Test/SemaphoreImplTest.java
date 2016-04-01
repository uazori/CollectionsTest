package Test;

import Car.Car;
import Semaphore.SemaphoreImpl;

import Car.EndlessCar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SemaphoreImplTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testAcquire() throws Exception {

        System.out.println(" Test Acquire ");
        final SemaphoreImpl semaphore = new SemaphoreImpl(5);

        semaphore.acquire();


        assertEquals(4,semaphore.getAvailablePermits());
    }

    @org.junit.Test
    public void testAcquireAmount() throws Exception {


        System.out.println(" Test Acquire (5) ");
        final SemaphoreImpl semaphore = new SemaphoreImpl(5);

        semaphore.acquire(3);


        assertEquals(2,semaphore.getAvailablePermits());

    }

    @org.junit.Test
    public void testRelease() throws Exception {

        System.out.println("Test Release");
        final SemaphoreImpl  semaphore = new SemaphoreImpl(10);

        semaphore.acquire(3);

        semaphore.release();

        assertEquals(8,semaphore.getAvailablePermits());


    }

    @org.junit.Test
    public void testReleaseAmount() throws Exception {

        System.out.println(" Test Release (10) ");
        final SemaphoreImpl semaphore = new SemaphoreImpl(5);

        semaphore.acquire(3);

        semaphore.release(2);

        assertEquals(4,semaphore.getAvailablePermits());

        semaphore.release(10);

        assertEquals(5,semaphore.getAvailablePermits());


    }


    @org.junit.Test
    public void testGetAvailablePermits() throws Exception {

        System.out.println("GetPermitsTest");
        final SemaphoreImpl  semaphore = new SemaphoreImpl(10);
        Thread[] Cars = new Thread[4];

        for (int i = 0; i < Cars.length; i++) {

            Cars[i] = new Thread(new EndlessCar(semaphore));
            Cars[i].start();
        }



        synchronized (this){
            this.wait(1000);
        }

        assertEquals(6, semaphore.getAvailablePermits());

        for (int i = 0; i < Cars.length; i++) {

            Cars[i].stop();
        }


    }

    @Test
    public void testHundredThreads() throws Exception{

        System.out.println("Hundred Thread Test ");

        SemaphoreImpl semaphore = new SemaphoreImpl(10);

        for (int i = 0; i < 100; i++) {
            new Thread(new Car(semaphore,25000)).start();
        }


    }
}