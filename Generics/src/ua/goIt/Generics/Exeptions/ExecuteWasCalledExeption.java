package ua.goIt.Generics.Exeptions;

/**
 * Created by Vadim on 18.03.2016.
 */
public class ExecuteWasCalledExeption extends Exception
{
    @Override
    public String getMessage() {
        return message;
    }

    private String message = " Execute method was called";
}
