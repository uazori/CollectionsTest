package ua.goit.calculator.dataTypes;

import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.operators.intOperators.AddIntOperator;
import ua.goit.calculator.operators.intOperators.MinusIntOperator;
import ua.goit.calculator.task.CalculatorTask;
import ua.goit.calculator.validator.DataValidator;

import java.util.HashMap;

/**
 * Created by Vadim on 25.04.2016.
 */
public class IntegerType implements DataType{
    HashMap<String, Operator> typeOperators = new HashMap<>();



    public IntegerType() {

        typeOperators.put("+",new AddIntOperator());
        typeOperators.put("-",new MinusIntOperator());

    }

    @Override
    public String execute(CalculatorTask task)throws OperatorNotFoundException{

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

    public void addOperator(String operatorSign, Operator operator){
        typeOperators.put(operatorSign,operator);
    }


}
