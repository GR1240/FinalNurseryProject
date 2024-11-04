package view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить новое животное");
        System.out.println("2. Вывести список команд животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Вывести список животных по дате рождения");
        System.out.println("5. Вывести количество животных");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");
    }

    @Override
    public void displayAnimalCommands(String name, List<String> commands) {
        System.out.println("Команды для " + name + ": " + String.join(", ", commands));
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayAnimalList(List<String> animalInfo) {
        for (String info : animalInfo) {
            System.out.println(info);
        }
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
