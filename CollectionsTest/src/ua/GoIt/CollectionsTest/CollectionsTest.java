package ua.GoIt.CollectionsTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vadim on 11.03.2016.
 */
public class CollectionsTest {
    String path = "result\\file.txt";
    File file = new File(path);
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    public CollectionsTest() {


            try {
                if (!file.exists()) {
                file.createNewFile();
                }
                fileWriter = new FileWriter(file.getAbsoluteFile());
                bufferedWriter = new BufferedWriter(fileWriter);


            } catch (IOException e) {
                e.printStackTrace();
            }


    }


    public void makeTest(int volume){



        try {
            printHeader(volume);


            makeArrayListTest(volume);
            makeLinkedListTest(volume);
            makeHashSetTest(volume);
            makeTreeSetTest(volume);


            bufferedWriter.write("\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void makeArrayListTest(int volume) throws IOException {



            TestArrayList testArrayList = new TestArrayList(volume);
            bufferedWriter.write(String.format("| %10s | %10d | %10d | %10d | %10d | %10d | %15d | %15d |\r\n",
                    "ArrayList",
                    testArrayList.testAdd(),
                    testArrayList.testGet(),
                    testArrayList.testRemove(),
                    testArrayList.testContains(),
                    testArrayList.testPopulate(),
                    testArrayList.testIteratorAdd(),
                    testArrayList.testIteratorRemove()));

            bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));
            bufferedWriter.flush();




    }
    private void makeLinkedListTest(int volume) throws IOException {



            TestLinkedList testLinkedList = new TestLinkedList(volume);
            bufferedWriter.write(String.format("| %10s | %10d | %10d | %10d | %10d | %10d | %15d | %15d |\r\n",
                    "LinkedList",
                    testLinkedList.testAdd(),
                    testLinkedList.testGet(),
                    testLinkedList.testRemove(),
                    testLinkedList.testContains(),
                    testLinkedList.testPopulate(),
                    testLinkedList.testIteratorAdd(),
                    testLinkedList.testIteratorRemove()));

            bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));
            bufferedWriter.flush();




    }

    private void makeHashSetTest(int volume) throws IOException {
        TestHashSet testHashSet = new TestHashSet(volume);
        bufferedWriter.write(String.format("| %10s | %10d | %10s | %10d | %10d | %10d | %15s | %15s |\r\n",
                "HashSet",
                testHashSet.testAdd(),
                "-",
                testHashSet.testRemove(),
                testHashSet.testContains(),
                testHashSet.testPopulate(),
                "-",
                "-"));

        bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));
        bufferedWriter.flush();

    }

    private void makeTreeSetTest(int volume) throws IOException {
        TestTreeSet testHashSet = new TestTreeSet(volume);
        bufferedWriter.write(String.format("| %10s | %10d | %10s | %10d | %10d | %10d | %15s | %15s |\r\n",
                "TreeSet",
                testHashSet.testAdd(),
                "-",
                testHashSet.testRemove(),
                testHashSet.testContains(),
                testHashSet.testPopulate(),
                "-",
                "-"));

        bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));
        bufferedWriter.flush();

    }

    private void printHeader(int volume) throws IOException {


        bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));
        bufferedWriter.write(String.format("| %10d | %10s | %10s | %10s | %10s | %10s | %15s | %15s |\r\n", volume, "add","get","remove","contains","populate","iterator.add","iterator.remove"));
        bufferedWriter.write(String.format("%80s\r\n", "-------------------------------------------------------------------------------------------------------------------"));

        bufferedWriter.flush();




    }

    public void printTable(){

        Path pathToFile = Paths.get(path);


        try (
                InputStream in = Files.newInputStream(pathToFile);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        }

    }
}
