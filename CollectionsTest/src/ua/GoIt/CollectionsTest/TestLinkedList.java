package ua.GoIt.CollectionsTest;

import java.util.*;

/**
 * Created by Vadim on 11.03.2016.
 */
public class TestLinkedList {
    LinkedList<Integer> data = new LinkedList<Integer>();
    Random generator = new Random();
    int volume;
    int testCount;


    public TestLinkedList(int volume,int testCount) {
        this.volume=volume;
        this.testCount = testCount;

        for (int i = 0; i < volume; i++) {

            data.add(generator.nextInt(Integer.MAX_VALUE));

        }


    }

    public long testAdd() {
        int i = generator.nextInt(Integer.MAX_VALUE);


        long start = System.currentTimeMillis();

        for (int j = 0; j < testCount; j++) {
            data.add(i);
        }

        long end = System.currentTimeMillis();

        long result = (end - start) / testCount;
        return result;
    }

    public long testGet() {

        int i = generator.nextInt(data.size());

        long start = System.currentTimeMillis();
        for (int j = 0; j < testCount; j++) {
            data.get(i);
        }

        long end = System.currentTimeMillis();


        long result = (end - start)/testCount;
        return result;
    }

    public long testRemove() {
        int i = generator.nextInt(data.size());

        long start = System.currentTimeMillis();
        for (int j = 0; j < testCount; j++) {
            data.remove(i);
        }

        long end = System.currentTimeMillis();

        long result = (end - start)/testCount;
        return result;
    }

    public long testContains() {
        int value = generator.nextInt(Integer.MAX_VALUE);

        long start = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            data.contains(value);
        }

        long end = System.currentTimeMillis();

        long result = (end - start)/testCount;
        return result;
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

    public long testIteratorAdd() {

        long start = System.currentTimeMillis();

        for (int i = 0; i < testCount; i++) {

            List<Integer> dataPopulate = new ArrayList<Integer>();
            ListIterator iterator = dataPopulate.listIterator();


            for (int j = 0; j < volume; j++) {

                iterator.add(j);

            }

        }

        long end = System.currentTimeMillis();
        long result = (end - start) /testCount ;
        return result;
    }

    public long testIteratorRemove() {
        Iterator iterator = data.iterator();
        long start = System.currentTimeMillis();

        while (iterator.hasNext()){

            iterator.next();
            iterator.remove();

        }


        long end = System.currentTimeMillis();
        long result = end - start;
        return result;
    }
}
