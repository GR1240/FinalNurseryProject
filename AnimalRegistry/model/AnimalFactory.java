package model;

import java.util.Date;

public class AnimalFactory {
    public Animal createAnimal(int type, String name, Date birthDate) {
        switch (type) {
            case 1:
                return new Dog(name, birthDate);
            case 2:
                return new Cat(name, birthDate);
            case 3:
                return new Hamster(name, birthDate);
            case 4:
                return new Horse(name, birthDate);
            case 5:
                return new Camel(name, birthDate);
            case 6:
                return new Donkey(name, birthDate);
            default:
                throw new IllegalArgumentException("Неверный тип животного.");
        }
    }
}
