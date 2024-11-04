import view.Menu;
import presenter.AnimalPresenter;
import presenter.AnimalPresenterImpl;
import view.View;
import view.ConsoleView;
import model.AnimalRegistry;



public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        View view = new ConsoleView();
        AnimalPresenter presenter = new AnimalPresenterImpl(registry, view);
        Menu menu = new Menu(view, presenter);

        menu.display();
    }
}
