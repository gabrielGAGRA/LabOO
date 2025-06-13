
// Controller for the add new result form view

public class AddController implements Controller {

    View view;
    LeagueStatsModel model;

    public AddController(LeagueStatsModel theModel) {

        view = new AddView(this, theModel);

        model = theModel;

        view.show();

    }

}
