import java.util.Date;

class Horse extends PackAnimal {
    public Horse(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("тросс");
        addCommand("кантер");
    }
}
