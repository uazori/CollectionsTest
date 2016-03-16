import ua.GoIt.CollectionsTest.CollectionsTest;

public class Main {

    public static void main(String[] args) {


            CollectionsTest test = new CollectionsTest();
        int testsCount =4;
            test.makeTest(10000,testsCount);
            test.makeTest(100000,testsCount);
            test.makeTest(1000000,testsCount);

            test.printTableFromFile();


    }
}
