package ua.goit.calculator.operators.doubleOperators;

import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 02.05.2016.
 */
public class DoubleConverter {
    protected double operand1;
    protected double operand2;
    protected void ConvertOperands(CalculatorTask task) {

        this.operand1 = Double.valueOf(task.getOperand1());
        this.operand2 = Double.valueOf(task.getOperand2());
    }
}
