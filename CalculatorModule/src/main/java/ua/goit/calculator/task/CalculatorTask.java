package ua.goit.calculator.task;

import ua.goit.calculator.exceptions.DataTypeNotFoundException;
import ua.goit.calculator.exceptions.IncorrectInputException;

/**
 * Created by Vadim on 24.04.2016.
 */
public interface CalculatorTask {

    public void setTask(String task) throws DataTypeNotFoundException, IncorrectInputException;

    public String getOperator();
    public String getOperand1();
    public String getOperand2();
    public String getDataType();


}
