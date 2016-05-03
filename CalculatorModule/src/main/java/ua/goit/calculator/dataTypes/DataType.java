package ua.goit.calculator.dataTypes;

import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;

/**
 * Created by Vadim on 25.04.2016.
 */
public interface DataType {
    public String execute(CalculatorTask task) throws OperatorNotFoundException;
    public void addOperator(String operatorSign, Operator operator);
}
