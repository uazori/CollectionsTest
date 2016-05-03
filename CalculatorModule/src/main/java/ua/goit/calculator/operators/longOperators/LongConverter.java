package ua.goit.calculator.operators.longOperators;

import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 02.05.2016.
 */
public class LongConverter {
    protected long operand1;
    protected long operand2;

    protected void ConvertOperands(CalculatorTask task) {

        this.operand1 = Long.valueOf(task.getOperand1()).longValue();
        this.operand2 = Long.valueOf(task.getOperand2()).longValue();

    }
}
