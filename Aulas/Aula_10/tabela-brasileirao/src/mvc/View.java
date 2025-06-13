package src.mvc;

import javax.swing.JFrame;

// View abstract class
// -- views should inherit this

public abstract class View {

    protected JFrame frame;

    protected Controller controller;
    protected LeagueStatsModel model;

    public View(Controller theController, LeagueStatsModel theModel) {

        controller = theController;

        model = theModel;

        createView();

    }

    public abstract void createView();

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
