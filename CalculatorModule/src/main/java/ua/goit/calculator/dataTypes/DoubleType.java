package ua.goit.calculator.dataTypes;

import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.operators.doubleOperators.AddDoubleOperator;
import ua.goit.calculator.operators.doubleOperators.MinusDoubleOperator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;

import java.util.HashMap;

/**
 * Created by Vadim on 27.04.2016.
 */
public class DoubleType implements DataType {

    HashMap<String, Operator> typeOperators = new HashMap<String, Operator>();


    public DoubleType() {

        typeOperators.put("+", new AddDoubleOperator());
        typeOperators.put("-", new MinusDoubleOperator());

    }

    @Override
    public String execute(CalculatorTask task) throws OperatorNotFoundException {

        String result;
        Operator operator = typeOperators.get(task.getOperator());
        if (operator==null){
            result = "error";
            throw new OperatorNotFoundException(task.getOperator()+" - operator not supported");

        }
        else {
            result = operator.Calculate(task);
        }
        return result;
    }

    @Override
    public void addOperator(String operatorSign, Operator operator) {
        typeOperators.put(operatorSign, operator);
    }


}
