package ua.goIt.Generics.Task;

/**
 * Created by Vadim on 18.03.2016.
 */
public class StringTask implements Task<String> {
    private String data;
    private String result;

    public StringTask(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void execute() {
        result=data+"all ok!!!";
    }

    @Override
    public String getResult() {
        return result;
    }
}
