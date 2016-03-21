package ua.goIt.Generics.Task;

/**
 * Created by Vadim on 21.03.2016.
 */
public class IntegerTask implements Task<Integer> {
    private Integer data;
    private Integer result;

    public IntegerTask(Integer data) {
        this.data = data;
    }

    @Override
    public void execute() {
        result=data+20;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
