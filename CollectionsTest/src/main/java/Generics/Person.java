package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 14.03.2016.
 */
public class Person {
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String name;
    public String surname;
    public boolean isValidList(List<? extends Person> persons,Validator<Person> personValidator){

        for (Person person : persons) {
            if (!personValidator.isValid(person)){
                return false;
            }
        }

    return true;
    }

    public <T>List<T> filterInvalid(List<T> values,Validator<? super T> validator){
List<T> result = new ArrayList<>();
        for (T value : values) {
          if (validator.isValid(value)){
              result.add(value);
          }
        }
return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
