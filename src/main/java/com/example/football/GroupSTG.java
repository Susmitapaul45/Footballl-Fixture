package com.example.football;

public class GroupSTG {

    private String teamName1;
    private String teamName2;
    private String date;

    private String time;

    public String getTeamName1() {
        return teamName1;
    }

    public String getTeamName2() {
        return teamName2;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTeamName1(String teamName1) {
        this.teamName1 = teamName1;
    }

    public void setTeamName2(String teamName2) {
        this.teamName2 = teamName2;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GroupSTG(String teamName1, String teamName2, String Date,String time) {
        this.teamName1 = teamName1;
        this.teamName2 = teamName2;
        this.date = Date;
        this.time= time;

    }
}
