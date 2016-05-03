package ua.goit.calculator.task;

import ua.goit.calculator.exceptions.DataTypeNotFoundException;
import ua.goit.calculator.exceptions.IncorrectInputException;

/**
 * Created by Vadim on 24.04.2016.
 */
public class Task implements CalculatorTask {

    String operator;
    String operand1;
    String operand2;
    String dataType;


    @Override
    public void setTask(String task) throws DataTypeNotFoundException, IncorrectInputException {

        String operandArray[] = task.split(" ");
        if (operandArray.length != 4){throw  new IncorrectInputException("incorrect input. example: <type operand1 operator operand2>");
        }else {

            dataType = operandArray[0];

            operand1 = operandArray[1];

            operator = operandArray[2];

            operand2 = operandArray[3];

        }


    }


    @Override
    public String getDataType() {
        return dataType;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public String getOperand1() {
        return operand1;
    }

    @Override
    public String getOperand2() {
        return operand2;
    }
}
