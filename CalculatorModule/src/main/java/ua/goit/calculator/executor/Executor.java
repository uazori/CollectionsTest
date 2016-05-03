package ua.goit.calculator.executor;

import ua.goit.calculator.exceptions.DataTypeNotFoundException;
import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 24.04.2016.
 */
public interface Executor {
    public String execute(CalculatorTask task) throws OperatorNotFoundException,DataTypeNotFoundException;

}
