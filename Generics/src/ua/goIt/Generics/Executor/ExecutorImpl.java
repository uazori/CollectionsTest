package ua.goIt.Generics.Executor;

import ua.goIt.Generics.Exceptions.ExecuteWasCalledException;
import ua.goIt.Generics.Task.Task;
import ua.goIt.Generics.Validator.Validator;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Vadim on 18.03.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {
    List<Task<? extends T>> tasks = new ArrayList<Task<? extends T>>();
    List<Validator> validators = new ArrayList<Validator>();


    List<T> validResults = new ArrayList<T>();
    List<T> inValidResults = new ArrayList<T>();


    @Override
    public void addTask(Task<? extends T> task) throws ExecuteWasCalledException {
        tasks.add(task);
        validators.add(null);

    }



    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecuteWasCalledException{
        tasks.add(task);
        validators.add(validator);

    }


    @Override
    public void execute() {


        for (int i = 0; i < tasks.size(); i++) {
            Task<? extends T> task = tasks.get(i);
            task.execute();
            Validator validator = validators.get(i);
            if (validator!=null) {
                if (validator.isValid(task.getResult())) {
                    validResults.add(task.getResult());
                } else {
                    inValidResults.add(task.getResult());
                }

            }else { validResults.add(task.getResult());}



        }

    }

    @Override
    public  List<T> getValidResults() {
        return validResults;
    }

    @Override
    public List<T> getInvalidResults() {
        return inValidResults;
    }
}
