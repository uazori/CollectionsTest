package ua.goIt.Generics.Exceptions;

/**
 * Created by Vadim on 18.03.2016.
 */
public class ExecuteWasCalledException extends Exception
{
    @Override
    public String getMessage() {
        return message;
    }

    private String message = " Execute method was called";
}
