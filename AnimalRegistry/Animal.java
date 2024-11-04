import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    private static int animalCount = 0;
    private String name;
    private Date birthDate;
    private List<String> commands = new ArrayList<>();

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
