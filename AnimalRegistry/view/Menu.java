package view;

import presenter.AnimalPresenter;

public class Menu {
    private final View view;
    private final AnimalPresenter presenter;

    public Menu(View view, AnimalPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    public void display() {
        boolean exit = false;
        while (!exit) {
            view.showMenu();
            String choice = view.getInput();
            switch (choice) {
                case "1":
                    presenter.addAnimal();
                    break;
                case "2":
                    presenter.showAnimalCommands();
                    break;
                case "3":
                    presenter.teachAnimalCommand();
                    break;
                case "4":
                    presenter.showAnimalsByBirthDate();
                    break;
                case "5":
                    presenter.showAnimalCount();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    view.displayMessage("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
