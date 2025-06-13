import src.mvc.Controller;
import src.mvc.TableController;
import src.mvc.AddController;
import src.mvc.LeagueStatsModel;
import src.mvc.LeagueStats;

// Aplicação

public class App {
    public static void main(String[] args) {
        LeagueStatsModel theModel = new LeagueStats();
        // theModel.populate(); // uncomment to start with a sample data of results

        Controller tableController = new TableController(theModel);

        Controller addController = new AddController(theModel);

    }
}
