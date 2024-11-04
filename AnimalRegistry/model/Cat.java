package model;

import java.util.Date;

class Cat extends Pet {
    public Cat(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("Meow");
        addCommand("Scratch");
        addCommand("Sit");
    }
}

