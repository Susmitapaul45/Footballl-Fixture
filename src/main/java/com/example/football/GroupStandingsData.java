package com.example.football;

public class GroupStandingsData {



    public String getTeamName() {
        return teamName;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public int getWon() {
        return won;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public int getPoints() {
        return points;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private String teamName;
    private int matchPlayed;
    private int won;
    private int lose;
    private int draw;
    private int points;


    public GroupStandingsData(String teamName, int matchPlayed, int won, int lose, int draw, int points) {
        this.teamName = teamName;
        this.matchPlayed = matchPlayed;
        this.won = won;
        this.lose = lose;
        this.draw = draw;
        this.points = points;
    }
}
