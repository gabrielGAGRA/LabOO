package LabOO.Aulas.Aula_10.tabela_MVC_facade.src.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import LabOO.Aulas.Aula_10.tabela_MVC_facade.src.view.ViewMudanca;

public class LeagueStats implements LeagueStatsModel {

    private HashMap<String, TeamStats> teams = new HashMap<>();
    private HashMap<String, String> abbreviations = new HashMap<>();
    private List<ViewMudanca> mudancas = new ArrayList<>();

    public LeagueStats() {
        abbreviations.put("SAO", "São Paulo");
        abbreviations.put("BOT", "Botafogo");
        abbreviations.put("ATH", "Atlético Paranaense");
        abbreviations.put("SAN", "Santos");
        abbreviations.put("CRU", "Cruzeiro");
        abbreviations.put("FOR", "Fortaleza");
        abbreviations.put("COR", "Corinthians");
        abbreviations.put("PAL", "Palmeiras");
        abbreviations.put("BAH", "Bahia");
        abbreviations.put("FLU", "Fluminense");
        abbreviations.put("ATL", "Atlético Mineiro");
        abbreviations.put("AME", "América");
        abbreviations.put("CUI", "Cuiabá");
        abbreviations.put("CUR", "Coritiba");
        abbreviations.put("INT", "Internacional");
        abbreviations.put("VAS", "Vasco");
        abbreviations.put("GOI", "Goiás");
        abbreviations.put("RED", "Red Bull Bragantino");
        abbreviations.put("FLA", "Flamengo");
        abbreviations.put("GRE", "Grêmio");

    }

    @Override
    public void addResult(String casaTime, int casaGols, String foraTime, int foraGols) {

        teams.putIfAbsent(casaTime, new TeamStats(abbreviations.get(casaTime)));
        teams.putIfAbsent(foraTime, new TeamStats(abbreviations.get(foraTime)));

        TeamStats teamScore1 = teams.get(casaTime);
        TeamStats teamScore2 = teams.get(foraTime);

        teamScore1.addResult(casaGols, foraGols);
        teamScore2.addResult(foraGols, casaGols);

        notifyMudanca();
    }

    @Override
    public Collection<TeamStats> getResults() {
        return teams.values();
    }

    public void showResults() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|        TEAM          |  P |  M |  W |  D |  L |  F |  A |  N |");
        System.out.println("|----------------------+----+----+----+----+----+----+----+----|");
        for (TeamStats score : teams.values()) {
            System.out.printf("| %20s | %2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d |\n", score.getName(),
                    score.getScore(), score.getNumberOfMatches(), score.getNumberOfWins(), score.getNumberOfDraws(),
                    score.getNumberOfLosses(), score.getGoalsFor(), score.getGoalsAgainst(),
                    score.getGoalsDifference());
        }
        System.out.println("+--------------------------------------------------------------+");
    }

    // Populates model with some fake data.
    // -- good for testing and demo purposes
    @Override
    public void populate() {

        teams.clear();

        addResult("SAO", 0, "PAL", 2);
        addResult("CUR", 0, "SAN", 0);
        addResult("ATL", 1, "RED", 1);
        addResult("BAH", 2, "CRU", 2);
        addResult("COR", 1, "CUI", 1);
        addResult("BOT", 2, "FOR", 0);
        addResult("AME", 2, "ATH", 2);
        addResult("INT", 2, "VAS", 1);
        addResult("GOI", 2, "FLU", 2);
        addResult("FLA", 3, "GRE", 0);

        addResult("SAO", 2, "ATH", 1);
        addResult("CRU", 0, "FOR", 1);
        addResult("SAN", 0, "COR", 2);
        addResult("FLU", 1, "ATL", 1);
        addResult("BAH", 1, "PAL", 0);

    }

    @Override
    public void registerMudanca(ViewMudanca o) {
        if (o != null && !mudancas.contains(o)) {
            mudancas.add(o);
        }
    }

    @Override
    public void removeMudanca(ViewMudanca o) {
        mudancas.remove(o);
    }

    public void notifyMudanca() {
        for (ViewMudanca Mudanca : new ArrayList<>(mudancas)) {
            Mudanca.update();
        }
    }

    // Demo
    public static void main(String[] args) {
        LeagueStats result = new LeagueStats();
        result.populate();
        result.showResults();
    }

}
