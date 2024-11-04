import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

public class ConsoleView {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить новое животное");
        System.out.println("2. Вывести список команд животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Вывести список животных по дате рождения");
        System.out.println("5. Вывести количество животных");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");
        return scanner.nextInt();
    }

    public String promptForName() {
        System.out.print("Введите имя животного: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public Date promptForBirthDate() {
        System.out.print("Введите дату рождения животного (yyyy-mm-dd): ");
        while (true) {
            try {
                return dateFormat.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Неверный формат даты. Попробуйте снова: ");
            }
        }
    }

    public int promptForAnimalType() {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Hamster");
        System.out.println("4. Horse");
        System.out.println("5. Camel");
        System.out.println("6. Donkey");
        return scanner.nextInt();
    }

    public void displayAnimalAdded() {
        System.out.println("Животное добавлено.");
    }

    public void displayAnimalCommands(Animal animal) {
        System.out.println("Команды для " + animal.getName() + ": " + String.join(", ", animal.getCommands()));
    }

    public void displayAnimalNotFound() {
        System.out.println("Животное не найдено.");
    }

    public void displayTotalAnimals(int count) {
        System.out.println("Общее количество животных: " + count);
    }

    public void displayAnimalsByBirthDate(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " - " + dateFormat.format(animal.getBirthDate()));
        }
    }
}
