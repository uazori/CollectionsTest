package ua.goIt.Generics.Executor;

import ua.goIt.Generics.Exceptions.ExecuteWasCalledException;
import ua.goIt.Generics.Exceptions.NoExecuteCallException;
import ua.goIt.Generics.Task.Task;
import ua.goIt.Generics.Validator.Validator;

import java.util.List;

/**
 * Created by Vadim on 18.03.2016.
 */
public interface Executor<T> {

    // Добавить таск на выполнение. Результат таска будет доступен через метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task) throws ExecuteWasCalledException;

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecuteWasCalledException;

    // Выполнить все добавленые таски
    void execute();

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    <T> List<T> getValidResults() throws NoExecuteCallException;

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
     List<T> getInvalidResults()throws NoExecuteCallException;

}
