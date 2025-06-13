package src.mvc;


import java.util.Collection;
import java.util.HashMap;

// Represents the scores of a league

public class LeagueStats implements LeagueStatsModel {

    private HashMap<String, TeamStats> teams = new HashMap<>();

    private HashMap<String, String> abbreviations = new HashMap<>();

    public LeagueStats() {

        // Abbreviations are useful for adding new results

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

    // homeTeam and visitorTeam are team abbreviations
    public void addResult(String homeTeam, int homeGoals, String visitorTeam, int visitorGoals) {

        teams.putIfAbsent(homeTeam, new TeamStats(abbreviations.get(homeTeam)));
        teams.putIfAbsent(visitorTeam, new TeamStats(abbreviations.get(visitorTeam)));

        TeamStats teamScore1 = teams.get(homeTeam);
        TeamStats teamScore2 = teams.get(visitorTeam);

        teamScore1.addResult(homeGoals, visitorGoals);
        teamScore2.addResult(visitorGoals, homeGoals);

    }

    public Collection<TeamStats> getResults() {
        return teams.values();
    }

    public void showResults() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|        TEAM          |  P |  M |  W |  D |  L |  F |  A |  N |");
        System.out.println("|----------------------+----+----+----+----+----+----+----+----|");
        for (TeamStats score: teams.values()) {
            System.out.printf("| %20s | %2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d |\n", 
                score.getName(),
                score.getScore(),
                score.getNumberOfMatches(),
                score.getNumberOfWins(),
                score.getNumberOfDraws(),
                score.getNumberOfDraws(),
                score.getGoalsFor(),
                score.getGoalsAgainst(),
                score.getGoalsDifference());
        }
        System.out.println("+--------------------------------------------------------------+");
    }

    // Populates model with some fake data.
    //   -- good for testing and demo purposes
    public void populate() {

        teams.clear(); // we will wipe out any previous data

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
    
    // Demo
    public static void main(String[] args) {
        LeagueStats result = new LeagueStats();
        result.populate();
        result.showResults();
    }
    
}
