package ua.goit.calculator.operators.longOperators;

import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 02.05.2016.
 */
public class MinusLongOperator extends LongConverter implements Operator {
    @Override
    public String Calculate(CalculatorTask task) {

        super.ConvertOperands(task);

        return String.valueOf(super.operand1 - super.operand2);
    }
}
