package ua.goIt.Generics.Validator;

import ua.goIt.Generics.Task.Task;

/**
 * Created by Vadim on 21.03.2016.
 */
public class NumberValidator implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        if ( result.intValue()> 0 ){return true;}

        return false;
    }
}
