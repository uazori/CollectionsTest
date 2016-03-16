package Generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vadim on 14.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Kolya","sosed");

        List<Person> persons = Arrays.asList(new Person("Pasha","Pavlov"),new Person("Lena","Lenina"),new Person("Sasha",""));
        List<Citizen> citizens = Arrays.asList(new Citizen("Pash","Pavlov","Lviv"),new Citizen("Lena","Lenina",""),new Citizen("Sasha","",""));

        List<Citizen> filteredCitizens = person.filterInvalid(citizens,new PersonValidator());
        System.out.println(person.isValidList(citizens, new PersonValidator() ));

    }
}
