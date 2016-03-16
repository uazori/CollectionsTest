package ua.GoIt.CollectionsTest;

import java.util.*;

/**
 * Created by Vadim on 11.03.2016.
 */
public class TestHashSet {

    HashSet<Integer> data = new HashSet<Integer>();
    Random generator = new Random();
    int volume;
    int testCount;


    public TestHashSet(int volume, int testCount) {
        this.volume=volume;
        this.testCount = testCount;

        for (int i = 0; i < volume; i++) {

            data.add(generator.nextInt(Integer.MAX_VALUE));

        }


    }

    public long testAdd() {



        long start = System.currentTimeMillis();

        for (int j = 0; j < testCount; j++) {
            data.add(j);
        }

        long end = System.currentTimeMillis();

        long result = (end - start) / testCount;
        return result;
    }



    public long testRemove() {


        long start = System.currentTimeMillis();

        for (int j = 0; j < testCount; j++) {
            data.remove(j);
        }

        long end = System.currentTimeMillis();

        long result = (end - start)/testCount;


        return result;
    }


    public long testContains() {
        long result = 0;
        long start;
        long end;


        for (int i = 0; i < testCount; i++) {

            int value = generator.nextInt(Integer.MAX_VALUE);

            start = System.currentTimeMillis();
            data.contains(value);
            end = System.currentTimeMillis();

            result+=(end - start);

        }


        return result/testCount;
    }

    public long testPopulate() {





        long start = System.currentTimeMillis();

        for (int i = 0; i < testCount; i++) {
            List<Integer> dataPopulate = new ArrayList<Integer>();

            for (int j = 0; j < volume; j++) {

                dataPopulate.add(i);

            }

        }

        long end = System.currentTimeMillis();

        long result = (end - start) / testCount;
        return result;
    }


}
