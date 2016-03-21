package ua.goIt.Generics.Validator;

import ua.goIt.Generics.Task.Task;

/**
 * Created by Vadim on 18.03.2016.
 */
public class StringValidator implements  Validator<String>{


    @Override
    public boolean isValid(String result) {
        if (result.length()> 3){return true;}
        return false;
    }
}
