package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.controller;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model.LeagueStatsModel;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view.AddView;
import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view.View;

public class AddController implements Controller {

    View view;
    LeagueStatsModel model;

    public AddController(LeagueStatsModel theModel) {
        this.model = theModel;
        this.view = new AddView(this, this.model);
        this.view.show();
    }

    public void ResultadoJogo(String casaTime, int casaGols, String foraTime, int foraGols) {
        model.addResult(casaTime, casaGols, foraTime, foraGols);
    }
}
