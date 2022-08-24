package com.example.football;

import javafx.fxml.FXML;

public class TeamsData {
    public void setTeamName(String teamName) {
        this.TeamName = teamName;
    }

    public void setCoachName(String coachName) {
        this.CoachName = coachName;
    }

    public void setFIFARanking(int FIFARanking) {
        this.FIFARanking = FIFARanking;
    }

    public void setTrophies(int trophies) {
       this.Trophies = trophies;
    }

    public TeamsData(String teamName, String coachName, int FIFARanking, int trophies) {
        this.TeamName = teamName;
        this.CoachName = coachName;
        this.FIFARanking = FIFARanking;
        this.Trophies = trophies;
    }

    private String TeamName;

    public String getTeamName() {
        return TeamName;
    }

    public String getCoachName() {
        return CoachName;
    }

    public int getFIFARanking() {
        return FIFARanking;
    }

    public int getTrophies() {
        return Trophies;
    }

    private String CoachName;
    private int FIFARanking;
    private int Trophies;
}
