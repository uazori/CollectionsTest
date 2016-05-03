package ua.goit.calculator.operators.floatOperators;

import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 27.04.2016.
 */
public class AddFloatOperator extends FloatConverter implements Operator {

    @Override
    public String Calculate(CalculatorTask task) {

        super.ConvertOperands(task);

        return String.valueOf(super.operand1 + super.operand2);
    }
}
