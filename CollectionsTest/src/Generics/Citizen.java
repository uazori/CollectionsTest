package Generics;

/**
 * Created by Vadim on 14.03.2016.
 */
public class Citizen extends Person {
    public String adress;

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "adress='" + adress + '\'' +
                '}';
    }

    public Citizen(String name, String surname,String adress) {
        super(name, surname);
        this.adress=adress;
    }
}
