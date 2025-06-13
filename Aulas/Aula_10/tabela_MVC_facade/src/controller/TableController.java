package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view.View;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view.TableView;

public class TableController implements Controller {

    View view;
    LeagueStatsModel model;

    public TableController(LeagueStatsModel theModel) {
        this.model = theModel;
        this.view = new TableView(this, this.model);
        this.view.show();
    }

}
