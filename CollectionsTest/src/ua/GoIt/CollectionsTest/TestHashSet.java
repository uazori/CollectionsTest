package ua.GoIt.CollectionsTest;

import java.util.*;

/**
 * Created by Vadim on 11.03.2016.
 */
public class TestHashSet {

    HashSet<Integer> data = new HashSet<Integer>();
    Random generator = new Random();
    int volume;


    public TestHashSet(int volume) {
        this.volume=volume;

        for (int i = 0; i < volume; i++) {

            data.add(generator.nextInt(Integer.MAX_VALUE));

        }


    }

    public long testAdd(){
        int i = generator.nextInt(Integer.MAX_VALUE);


        long start =System.currentTimeMillis();
        data.add(i);
        long end = System.currentTimeMillis();

        long result=end-start;
        return result;}



    public long testRemove(){
        int i = generator.nextInt(Integer.MAX_VALUE);

        long start =System.currentTimeMillis();
        data.remove(i);
        long end = System.currentTimeMillis();

        long result=end-start;
        return result;}

    public long testContains(){
        int value =generator.nextInt(Integer.MAX_VALUE);

        long start =System.currentTimeMillis();
        data.contains(value);
        long end = System.currentTimeMillis();

        long result=end-start;
        return result;}

    public long testPopulate(){


        List<Integer> dataPopulate = new ArrayList<Integer>();



        long start =System.currentTimeMillis();

        for (int i = 0; i < volume; i++) {

            dataPopulate.add(123);

        }



        long end = System.currentTimeMillis();

        long result=end-start;
        return result;}


}
