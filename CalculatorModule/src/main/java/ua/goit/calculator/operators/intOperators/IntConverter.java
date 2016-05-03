package ua.goit.calculator.operators.intOperators;

import ua.goit.calculator.task.CalculatorTask;

/**
 * Created by Vadim on 27.04.2016.
 */
public class IntConverter {

     protected int operand1;
     protected int operand2;

    protected void ConvertOperands(CalculatorTask task) {

        this.operand1 = Integer.valueOf(task.getOperand1());
        this.operand2 = Integer.valueOf(task.getOperand2());

    }
}
