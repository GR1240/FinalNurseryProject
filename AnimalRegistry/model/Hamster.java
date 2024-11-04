package model;

import java.util.Date;

class Hamster extends Pet {
    public Hamster(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("Roll");
        addCommand("Spin");
    }
}
