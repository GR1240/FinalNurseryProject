package view;

import java.util.List;

public interface View {
    void showMenu();
    void displayAnimalCommands(String name, List<String> commands);
    void displayMessage(String message);
    void displayAnimalList(List<String> animalInfo);
    String getInput();
}
