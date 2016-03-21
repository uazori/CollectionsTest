import ua.goIt.Generics.Exeptions.ExecuteWasCalledExeption;
import ua.goIt.Generics.Exeptions.NoExecuteCallExeption;
import ua.goIt.Generics.Task.IntegerTask;
import ua.goIt.Generics.Task.LongTask;
import ua.goIt.Generics.Task.Task;
import ua.goIt.Generics.Executor.Executor;
import ua.goIt.Generics.Executor.ExecutorImpl;
import ua.goIt.Generics.Task.StringTask;
import ua.goIt.Generics.Validator.NumberValidator;
import ua.goIt.Generics.Validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List< Task<Integer> > tasks = new ArrayList<  Task<Integer> >();
        Task<Long> task = new LongTask(10L);
        Task<Long> task1 = new LongTask(-9L);
        Task<Integer> task2 = new IntegerTask(-110);

        tasks.add(new IntegerTask(-110) );
        tasks.add( new IntegerTask(-220) );
        tasks.add( new IntegerTask(-330) );


        numberTest(tasks);

    }

    public static void numberTest(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<Number>();

        for (Task<Integer> intTask : intTasks) {

            try {
                numberExecutor.addTask(intTask);
            } catch (ExecuteWasCalledExeption executeWasCalledExeption) {
                executeWasCalledExeption.printStackTrace();
            }

        }

        try {
            numberExecutor.addTask(new LongTask(10L), new NumberValidator());
            numberExecutor.addTask(new LongTask(10L), new NumberValidator());
            numberExecutor.addTask(new IntegerTask(-110), new NumberValidator());
            numberExecutor.addTask(new IntegerTask(-220), new NumberValidator());
            numberExecutor.addTask(new IntegerTask(-9), new NumberValidator());
            numberExecutor.addTask(new LongTask(-9L), new NumberValidator());


        } catch (ExecuteWasCalledExeption executeWasCalledExeption) {
            executeWasCalledExeption.printStackTrace();
        }

        numberExecutor.execute();

        System.out.println("Valid results:");
        List<Number> validResults = new ArrayList<Number>();
        try {
            validResults = numberExecutor.getValidResults();
        } catch (NoExecuteCallExeption noExecuteCallExeption) {
            noExecuteCallExeption.printStackTrace();
        }


        for (Number number : validResults ) {
            System.out.println(number);
        }

        System.out.println("Invalid results:");
        List<Number> inValidResults = new ArrayList<Number>();
        try {
            inValidResults = numberExecutor.getInvalidResults();
        } catch (NoExecuteCallExeption noExecuteCallExeption) {
            noExecuteCallExeption.printStackTrace();
        }
        for (Number number : inValidResults) {
            System.out.println(number);
        }
    }
}
