package ua.goit.calculator.executor;

import ua.goit.calculator.dataTypes.DataType;
import ua.goit.calculator.exceptions.DataTypeNotFoundException;
import ua.goit.calculator.exceptions.OperatorNotFoundException;
import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

import java.util.HashMap;

/**
 * Created by Vadim on 25.04.2016.
 */
public class TaskExecutor implements Executor {

    HashMap<String, DataType> dataTypesExecutors = new HashMap<String, DataType>();


    @Override
    public String execute(CalculatorTask task) throws OperatorNotFoundException, DataTypeNotFoundException {

        String dataType = task.getDataType();


        DataType dataTypeExecutor = dataTypesExecutors.get(dataType);


        if (dataTypeExecutor == null) {
            throw new DataTypeNotFoundException(dataType + " - type not supported!!!");
        } else {

            return dataTypeExecutor.execute(task);

        }


    }

    public void addOperator(String typeName, String operatorSign, Operator operator) throws DataTypeNotFoundException {

        DataType dataType = dataTypesExecutors.get(typeName);
        if (dataType == null) {
            throw new DataTypeNotFoundException("Can`t add operator " + operatorSign + " to " + typeName + "data type, data type not found");

        } else {

            dataType.addOperator(operatorSign, operator);

            dataTypesExecutors.put(typeName, dataType);
        }

    }

    public void addType(String dataTypeName, DataType dataType) {

        dataTypesExecutors.put(dataTypeName, dataType);

    }


}
