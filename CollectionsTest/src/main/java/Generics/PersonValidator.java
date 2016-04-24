package Generics;



//import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Vadim on 14.03.2016.
 */
public class PersonValidator implements Validator<Person>{
    @Override
    public boolean isValid(Person value) {
        return true/*isBlank(value.name)&& isBlank(value.surname)*/;
    }
}
