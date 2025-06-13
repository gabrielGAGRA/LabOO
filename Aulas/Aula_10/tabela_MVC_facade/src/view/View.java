package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view;

import javax.swing.JFrame;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.Controller;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;

// View abstract class
// -- views should inherit this

public abstract class View implements ViewMudanca {

    protected JFrame frame;

    protected Controller controller;
    protected LeagueStatsModel model;

    public View(Controller theController, LeagueStatsModel theModel) {

        controller = theController;

        model = theModel;

        model.registerMudanca(this);

        createView();

    }

    public abstract void createView();

    @Override
    public void update() {
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
