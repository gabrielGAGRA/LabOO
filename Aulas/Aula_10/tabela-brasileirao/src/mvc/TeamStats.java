package src.mvc;



// Represents statistics about a team

public class TeamStats {
    public static final int pointsForWin = 3;
    public static final int pointsForDraw = 1;

    private String name;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;
    private int goalsFor;
    private int goalsAgainst;
    private int numberOfMatches;

    public TeamStats(String name) {
        this.name = name;
    }

    public int getScore() {
        return getNumberOfWins()*pointsForWin + getNumberOfDraws()*pointsForDraw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int noWins) {
        this.numberOfWins = noWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int noLoss) {
        this.numberOfLosses = noLoss;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int noTies) {
        this.numberOfDraws = noTies;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsScored) {
        this.goalsFor = goalsScored;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsSuffered) {
        this.goalsAgainst = goalsSuffered;
    }

    public int getGoalsDifference() {
        return goalsFor - goalsAgainst;
    }

    public void addResult(int goalsFor, int goalsAgainst) {
        numberOfMatches++;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
        if (goalsFor > goalsAgainst) {
            numberOfWins++;
        } else if (goalsFor < goalsAgainst) {
            numberOfLosses++;
        } else {
            numberOfDraws++;
        }
    }

    @Override
    public String toString() {
        return "Team: " + getName() + 
              "\nScore: " + getScore() + 
              "\nMatches: " + getNumberOfMatches() + 
              "\nWins: " + getNumberOfWins() + 
              "\nDraws: " + getNumberOfDraws() + 
              "\nLosses: " + getNumberOfLosses() + 
              "\nGoals For: " + getGoalsFor() + 
              "\nGoals Against: " + getGoalsAgainst() + 
              "\nNet Difference: " + getGoalsDifference();
    }

    // Demo
    public static void main(String[] args) {
        TeamStats botafogo = new TeamStats("Botafogo");
        botafogo.setNumberOfMatches(10);
        botafogo.setNumberOfWins(8);
        botafogo.setNumberOfDraws(0);
        botafogo.setNumberOfLosses(2);
        botafogo.setGoalsFor(18);
        botafogo.setGoalsAgainst(7);

        System.out.println(botafogo);
    }

}
