package ua.goIt.Generics.Validator;

import ua.goIt.Generics.Task.Task;

/**
 * Created by Vadim on 18.03.2016.
 */
public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}
