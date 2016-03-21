package ua.goIt.Generics.Task;

/**
 * Created by Vadim on 18.03.2016.
 */
public interface Task<T> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

}
