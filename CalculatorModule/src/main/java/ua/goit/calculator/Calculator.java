package ua.goit.calculator;

import ua.goit.calculator.dataTypes.*;
import ua.goit.calculator.exceptions.DataTypeNotFoundException;
import ua.goit.calculator.exceptions.IncorrectInputException;
import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.executor.TaskExecutor;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.Task;

/**
 * Created by Vadim on 27.04.2016.
 */
public class Calculator {

   private TaskExecutor executor = new TaskExecutor();

    public Calculator() {


        executor.addType("i",new IntegerType());
        executor.addType("f", new FloatType());
        executor.addType("d", new DoubleType());
        executor.addType("L", new LongType());


    }

    public String calculate(String input) {
        String result;
        Task task = new Task();
        try {

            task.setTask(input);
            result = executor.execute(task);

        } catch (DataTypeNotFoundException e) {
            System.out.println("error - " + e.getMessage());
            result = "error";
        }
        catch (OperatorNotFoundException e){
            System.out.println("error - " + e.getMessage());
            result = "error";
        } catch (IncorrectInputException e) {
            System.out.println("error - " + e.getMessage());
            result = "error";
        }


        return result;

    }

    public void addOperator(String typeName, String operatorSign, Operator operator) {
        try {
            executor.addOperator(typeName, operatorSign, operator);
        } catch (DataTypeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addType(String dataTypeName, DataType dataType) {

          executor.addType(dataTypeName , dataType);
    }
}
