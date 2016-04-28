package ua.goit.java.operators;

import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 27.04.2016.
 */
public class AddDoubleOperator implements Operator {
    @Override
    public String Calculate(CalculatorTask task) {

        float operand1 = Float.valueOf(task.getOperand1());
        float operand2 = Float.valueOf(task.getOperand2());

        return String.valueOf(operand1 + operand2);
    }
}
