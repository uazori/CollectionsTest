package ua.goit.calculator.validator;

import ua.goit.calculator.exceptions.DataTypeNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 25.04.2016.
 */
public class InputValidator {



    private List<DataValidator> dataValidators = new ArrayList<DataValidator>();

    public String getDataType(String input) throws DataTypeNotFoundException{
        String result = null;
        for (int i = 0; i < dataValidators.size(); i++) {
            DataValidator dataValidator = dataValidators.get(i);
            if (input.contains(dataValidator.getDataString())){result=dataValidator.getDataName();}

        }
       if (result==null){throw  new DataTypeNotFoundException(input + " - type not supported!!!");}
        else {
           return result;
       }
    }

    public void addValidator(DataValidator dataValidator){
        dataValidators.add(dataValidator);
    }

}
