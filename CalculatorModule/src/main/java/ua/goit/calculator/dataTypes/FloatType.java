package ua.goit.calculator.dataTypes;

import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.operators.floatOperators.AddFloatOperator;
import ua.goit.calculator.operators.floatOperators.MinusFloatOperator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;

import java.util.HashMap;

/**
 * Created by Vadim on 27.04.2016.
 */
public class FloatType implements DataType {
    HashMap<String, Operator> typeOperators = new HashMap<>();
    DataValidator dataValidator =new DataValidator();

    public FloatType() {

       typeOperators.put("+",new AddFloatOperator());
       typeOperators.put("-",new MinusFloatOperator());
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

    }


}
