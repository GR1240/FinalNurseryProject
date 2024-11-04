import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Animal> animals = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("Меню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Вывести список команд животного");
                System.out.println("3. Обучить животное новой команде");
                System.out.println("4. Вывести список животных по дате рождения");
                System.out.println("5. Вывести количество животных");
                System.out.println("6. Выйти");
                System.out.print("Выберите опцию: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addAnimal(scanner);
                        break;
                    case 2:
                        listAnimalCommands(scanner);
                        break;
                    case 3:
                        trainAnimal(scanner);
                        break;
                    case 4:
                        listAnimalsByBirthDate();
                        break;
                    case 5:
                        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова.");
                }
            }
        } // Scanner автоматически закроется здесь
    }

    private static void addAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного (yyyy-mm-dd): ");
        String birthDateString = scanner.nextLine();
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse(birthDateString);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Попробуйте снова.");
            return;
        }

        System.out.println("Выберите тип животного:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Hamster");
        System.out.println("4. Horse");
        System.out.println("5. Camel");
        System.out.println("6. Donkey");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Animal animal = null;
        switch (type) {
            case 1:
                animal = new Dog(name, birthDate);
                break;
            case 2:
                animal = new Cat(name, birthDate);
                break;
            case 3:
                animal = new Hamster(name, birthDate);
                break;
            case 4:
                animal = new Horse(name, birthDate);
                break;
            case 5:
                animal = new Camel(name, birthDate);
                break;
            case 6:
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Неверный тип животного.");
                return;
        }
        animals.add(animal);
        System.out.println("Животное добавлено.");
    }

    private static void listAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Команды для " + name + ": " + String.join(", ", animal.getCommands()));
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private static void trainAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Введите новую команду для " + name + ": ");
                String command = scanner.nextLine();
                animal.addCommand(command);
                System.out.println(name + " обучено новой команде.");
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private static void listAnimalsByBirthDate() {
        animals.stream()
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .forEach(animal -> System.out.println(animal.getName() + " - " + dateFormat.format(animal.getBirthDate())));
    }
}
