import java.util.Date;

class Camel extends PackAnimal {
    public Camel(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("ходить");
        addCommand("носить груз");
    }
}

