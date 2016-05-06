package ua.goit.java.dataType;

import ua.goit.calculator.dataTypes.DataType;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;
import ua.goit.calculator.validator.InputValidator;

import java.util.HashMap;

/**
 * Created by Vadim on 27.04.2016.
 */
public class DateType implements DataType {

    HashMap<String, Operator> typeOperators = new HashMap<String, Operator>();


    @Override
    public String execute(CalculatorTask task) {
        Operator operator = typeOperators.get(task.getOperator());
        return operator.Calculate(task);
    }

    @Override
    public void addOperator(String operatorSign, Operator operator) {
        typeOperators.put(operatorSign, operator);
    }


}
