package ua.goit.calculator.dataTypes;

import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.operators.longOperators.AddLongOperator;
import ua.goit.calculator.operators.longOperators.MinusLongOperator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;

import java.util.HashMap;

/**
 * Created by Vadim on 02.05.2016.
 */
public class LongType implements DataType {
    HashMap<String, Operator> typeOperators = new HashMap<>();

    public LongType() {

        typeOperators.put("+", new AddLongOperator());
        typeOperators.put("-", new MinusLongOperator());

    }


    @Override
    public String execute(CalculatorTask task) throws OperatorNotFoundException{
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
