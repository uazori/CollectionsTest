import ua.GoIt.CollectionsTest.CollectionsTest;

public class Main {

    public static void main(String[] args) {


            CollectionsTest test = new CollectionsTest();
        int testsCount =5;
        int volume = 10000;
        test.makeTest(volume,testsCount);
        test.makeTest(100000,testsCount);
        test.makeTest(1000000,testsCount);

        test.printTableFromFile();


    }
}
