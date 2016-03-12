import ua.GoIt.CollectionsTest.CollectionsTest;

public class Main {

    public static void main(String[] args) {


            CollectionsTest test = new CollectionsTest();
            test.makeTest(10000);
            test.makeTest(100000);
            test.makeTest(1000000);

            test.printTable();


    }
}
