package presenter;

import model.Animal;
import model.AnimalFactory;
import model.AnimalRegistry;
import view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalPresenterImpl implements AnimalPresenter {
    private final AnimalRegistry registry;
    private final View view;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public AnimalPresenterImpl(AnimalRegistry registry, View view) {
        this.registry = registry;
        this.view = view;
    }

    @Override
    public void addAnimal() {
        view.displayMessage("Введите имя животного:");
        String name = view.getInput();
        view.displayMessage("Введите дату рождения животного (yyyy-mm-dd):");
        String birthDateStr = view.getInput();
        Date birthDate;
        try {
            birthDate = dateFormat.parse(birthDateStr);
        } catch (ParseException e) {
            view.displayMessage("Неверный формат даты. Попробуйте снова.");
            return;
        }

        view.displayMessage("Введите тип животного (1: Dog, 2: Cat, 3: Hamster, 4: Horse, 5: Camel, 6: Donkey):");
        int animalType;
        try {
            animalType = Integer.parseInt(view.getInput());
        } catch (NumberFormatException e) {
            view.displayMessage("Пожалуйста, введите корректный номер типа животного.");
            return;
        }

        AnimalFactory factory = new AnimalFactory();
        Animal animal;

        try {
            animal = factory.createAnimal(animalType, name, birthDate);
            registry.addAnimal(animal);
            view.displayMessage("Животное добавлено.");
        } catch (IllegalArgumentException e) {
            view.displayMessage(e.getMessage());
        }
    }

    @Override
    public void showAnimalCommands() {
        view.displayMessage("Введите имя животного:");
        String name = view.getInput();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            view.displayAnimalCommands(name, animal.getCommands());
        } else {
            view.displayMessage("Животное не найдено.");
        }
    }

    @Override
    public void teachAnimalCommand() {
        view.displayMessage("Введите имя животного:");
        String name = view.getInput();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            view.displayMessage("Введите новую команду:");
            String command = view.getInput();
            animal.addCommand(command);
            view.displayMessage(name + " обучено новой команде.");
        } else {
            view.displayMessage("Животное не найдено.");
        }
    }

    @Override
    public void showAnimalsByBirthDate() {
        List<String> animalsInfo = registry.getAnimalsByBirthDate().stream()
                .map(animal -> animal.getName() + " - " + dateFormat.format(animal.getBirthDate()))
                .collect(Collectors.toList());
        view.displayAnimalList(animalsInfo);
    }

    @Override
    public void showAnimalCount() {
        view.displayMessage("Общее количество животных: " + registry.getAnimalCount());
    }
}
