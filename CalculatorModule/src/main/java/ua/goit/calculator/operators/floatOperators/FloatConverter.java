package ua.goit.calculator.operators.floatOperators;

import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 27.04.2016.
 */
public class FloatConverter {
    protected float operand1;
    protected float operand2;
    protected void ConvertOperands(CalculatorTask task) {

        this.operand1 = Float.valueOf(task.getOperand1());
        this.operand2 = Float.valueOf(task.getOperand2());
    }
}
