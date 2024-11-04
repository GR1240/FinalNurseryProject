import java.util.Date;

class Dog extends Pet {
    public Dog(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("Sit");
        addCommand("Paw");
    }
}
