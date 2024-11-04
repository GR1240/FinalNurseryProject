import java.util.Date;

class Donkey extends PackAnimal {
    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("ходить");
        addCommand("крик");
    }
}
