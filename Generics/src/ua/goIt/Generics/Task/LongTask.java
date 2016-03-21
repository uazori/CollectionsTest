package ua.goIt.Generics.Task;

/**
 * Created by Vadim on 21.03.2016.
 */
public class LongTask implements Task<Long> {
    private Long data;
    private Long result;

    public LongTask(Long data) {
        this.data = data;
    }


    @Override
    public void execute() {
        result=data+10;

    }

    @Override
    public Long getResult() {
        return result;
    }
}
