import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getAnimalsSortedByBirthDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        return animals;
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}
