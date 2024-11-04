package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalRegistry {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimalsByBirthDate() {
        return animals.stream()
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .collect(Collectors.toList());
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public Animal findAnimalByName(String name) {
        return animals.stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

