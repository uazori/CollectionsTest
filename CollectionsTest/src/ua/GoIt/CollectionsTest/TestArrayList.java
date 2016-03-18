package ua.GoIt.CollectionsTest;

import java.util.*;

/**
 * Created by Vadim on 11.03.2016.
 */
public class TestArrayList {

    List<Integer> data = new ArrayList<Integer>();
    Random generator = new Random();
    List<Integer> dataPopulate = new ArrayList<>();
    int volume;
    int testCount;


    public TestArrayList(int volume,int testCount) {
        this.testCount = testCount;
        this.volume = volume;

        for (int i = 0; i < volume; i++) {

            data.add(generator.nextInt(Integer.MAX_VALUE));

        }


    }

    public long testAdd() {


        List<Long> timeAdd = new ArrayList<Long>();



        for (int j = 0; j < testCount; j++) {


            long start = System.currentTimeMillis();

            for (int k = 0; k < volume; k++) {
                data.add(k);
            }

            long end = System.currentTimeMillis();

            timeAdd.add((end - start));
        }

        long result=0;

        for (Long aLong : timeAdd) {
        result+= aLong;
        }



        return result/testCount;
    }

    public long testGet() {

        List<Long> timeAdd = new ArrayList<Long>();



        for (int j = 0; j < testCount; j++) {

            long start = System.currentTimeMillis();

            for (int k = 0; k < volume; k++) {
                data.get(k);
            }

            long end = System.currentTimeMillis();

            timeAdd.add((end - start));
        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }



        return result/testCount;
    }

    public long testRemove() {
        List<Long> timeAdd = new ArrayList<Long>();



        for (int j = 0; j < testCount; j++) {

            long start = System.currentTimeMillis();

            for (int k = 0; k < volume; k++) {
                data.remove(k);
            }

            long end = System.currentTimeMillis();

            timeAdd.add((end - start));
        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }



        return result/testCount;
    }

    public long testContains() {


        List<Long> timeAdd = new ArrayList<Long>();



        for (int j = 0; j < testCount; j++) {

            long start = System.currentTimeMillis();

            for (int k = 0; k < volume; k++) {
                data.contains(k);
            }

            long end = System.currentTimeMillis();

            timeAdd.add((end - start));
        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }



        return result/testCount;
    }

    public long testPopulate() {

        List<Long> timeAdd = new ArrayList<Long>();





        for (int i = 0; i < testCount; i++) {


            long start = System.currentTimeMillis();

            for (int j = 0; j < volume; j++) {

                dataPopulate.add(i);

            }
            long end = System.currentTimeMillis();
            timeAdd.add((end - start));

        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }

        return result/testCount;
    }


    public long testIteratorAdd() {
        List<Long> timeAdd = new ArrayList<Long>();


        for (int i = 0; i < testCount; i++) {


            ListIterator iterator = dataPopulate.listIterator();

            long start = System.currentTimeMillis();
            for (int j = 0; j < volume; j++) {

                iterator.add(j);

            }
            long end = System.currentTimeMillis();
            timeAdd.add((end - start));

        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }

        return result/testCount;
    }

    public long testIteratorRemove() {

        List<Long> timeAdd = new ArrayList<Long>();


        for (int i = 0; i < testCount; i++) {


            ListIterator iterator = dataPopulate.listIterator();

            long start = System.currentTimeMillis();

            while(iterator.hasNext()){

                iterator.next();
                iterator.remove();

            }

            long end = System.currentTimeMillis();
            timeAdd.add((end - start));

        }

        long result=0;

        for (Long aLong : timeAdd) {
            result+= aLong;
        }

        return result/testCount;
    }

}
