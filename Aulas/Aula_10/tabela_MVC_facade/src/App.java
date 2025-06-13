package LabOO.Aulas.Aula_10.tabela_MVC_facade.src;

// Aplicação

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.AddController;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.Controller;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller.TableController;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStats;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;

public class App {
    public static void main(String[] args) {
        LeagueStatsModel theModel = new LeagueStats();
        theModel.populate();

        Controller tableController = new TableController(theModel);

        Controller addController = new AddController(theModel);

    }
}
