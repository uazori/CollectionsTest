package ua.goit.calculator.operators.doubleOperators;

import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 27.04.2016.
 */
public class AddDoubleOperator extends DoubleConverter implements Operator {
    @Override
    public String Calculate(CalculatorTask task) {

        super.ConvertOperands(task);


        return String.valueOf(super.operand1 + super.operand2);
    }
}
