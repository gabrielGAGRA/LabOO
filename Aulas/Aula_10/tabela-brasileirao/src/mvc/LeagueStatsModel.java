package src.mvc;

import java.util.Collection;

// Interface for league stats model
// -- allows us to change implementation in future

public interface LeagueStatsModel {
    void addResult(String team1, int goals1, String team2, int goals2);
    public Collection<TeamStats> getResults();
    void populate();
}
