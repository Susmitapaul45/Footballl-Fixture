package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateScore implements Initializable {
    private String current = "UpdateScore.fxml";

    HelloApplication h = new HelloApplication();
    Connection conn = h.getDbConnection();
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private Button Home;
    @FXML
    private Button Logout;

    @FXML
    private Button Back;

    @FXML
    private Button update;

    @FXML
    private ComboBox matchSelector;

    @FXML
    private Label team1;

    @FXML
    private Label team2;

    @FXML
    private TextField team1Score;

    @FXML
    private TextField team2Score;

    private HashMap<String, String> teamInfo;

    private ObservableList<String> getMatches() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            String sql = "Select group_name, team1,team2 from schedule";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                teamInfo.put(rs.getString(2).toString(), rs.getString(1).toString());
                teamInfo.put(rs.getString(3).toString(), rs.getString(1).toString());
                list.add(rs.getString(2) + " vs " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teamInfo = new HashMap<>();

        matchSelector.setItems(getMatches());
        matchSelector.setValue(getMatches().get(1));

        String s = getMatches().get(1).toString();
        String[] array = s.split(" vs ");
        team1.setText(array[0].toString() + "'s Score");
        team2.setText(array[1].toString() + "'s Score");
    }

    @FXML
    protected void onUpdateButtonClick() throws IOException{
        try {
            if (!validGoals(team1Score.getText().toString())) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid input for team1 score");
                errorAlert.showAndWait();
                return;
            }
            if (!validGoals(team2Score.getText().toString())) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid input for team2 score");
                errorAlert.showAndWait();
                return;
            }

            String s = matchSelector.getValue().toString();
            String[] array = s.split(" vs ");
            String team1 = array[0].toString();
            String team2 = array[1].toString();

            int goalOfTeam1 = Integer.parseInt(team1Score.getText().toString());
            int goalOfTeam2 = Integer.parseInt(team2Score.getText().toString());

            if (goalOfTeam1 == goalOfTeam2) {
                updateStandingsOnDraw(team1);
                updateStandingsOnDraw(team2);
            } else if (goalOfTeam1 > goalOfTeam2) {
                updateStandingsOnWin(team1);
                updateStandingsOnDefeat(team2);
            } else {
                updateStandingsOnWin(team2);
                updateStandingsOnDefeat(team1);
            }
            JOptionPane.showMessageDialog(null, "The score is updated successfully!");
            h.changeScene(current, "CurrentStand.fxml");
        } catch (Exception e){
            System.out.println(e);
        }

    }

    @FXML
    protected void onMatchSelectorChange(){
        String s = matchSelector.getValue().toString();
        String[] array = s.split(" vs ");
        team1.setText(array[0].toString() + "'s Score");
        team2.setText(array[1].toString() + "'s Score");
    }

    @FXML
    protected void onHomeButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Home.fxml");
    }
    @FXML
    protected void onLogoutButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"logout.fxml");
    }
    @FXML
    protected void onBackButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }

    private void updateStandingsOnWin(String team){
        System.out.println("Win: "+  team);

        try {
            String group_name = teamInfo.get(team);

            String sql = "Select * from standings where group_name=? AND team=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, group_name);
            pst.setString(2, team);
            rs = pst.executeQuery();

            if (rs.next()) {
                int match_played = rs.getInt(3);
                int win = rs.getInt(4);
                int lose = rs.getInt(5);
                int draw = rs.getInt(6);
                int pts = rs.getInt(7);

                match_played += 1;
                win += 1;
                pts += 3;

                String sql2 = "Update standings SET win=?, match_played=?, points=? where group_name=" + group_name + " AND team="+team;

                pst = conn.prepareStatement(sql2);
                pst.setInt(1,win);
                pst.setInt(2,match_played);
                pst.setInt(3,pts);
                pst.execute();
            }
            else{
                String sql2 = "INSERT INTO standings(group_name,team,match_played,win,lose,draw,points) values(?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql2);
                pst.setString(1, group_name);
                pst.setString(2, team);
                pst.setInt(3,1);
                pst.setInt(4,1);
                pst.setInt(5,0);
                pst.setInt(6,0);
                pst.setInt(7,3);

                pst.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateStandingsOnDraw(String team){
        System.out.println("Draw: "+  team);

        try {
            String group_name = teamInfo.get(team);

            String sql = "Select * from standings where group_name=? AND team=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, group_name);
            pst.setString(2, team);
            rs = pst.executeQuery();

            if (rs.next()) {
                int match_played = rs.getInt(3);
                int win = rs.getInt(4);
                int lose = rs.getInt(5);
                int draw = rs.getInt(6);
                int pts = rs.getInt(7);

                match_played += 1;
                pts += 1;
                draw += 1;

                String sql2 = "Update standings SET draw=?, match_played=?, points=? where group_name=" + group_name + " AND team="+team;

                pst = conn.prepareStatement(sql2);
                pst.setInt(1, draw);
                pst.setInt(2,match_played);
                pst.setInt(3,pts);

                pst.execute();
            }
            else{
                String sql2 = "INSERT INTO standings(group_name,team,match_played,win,lose,draw,points) values(?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql2);
                pst.setString(1, group_name);
                pst.setString(2, team);
                pst.setInt(3,1);
                pst.setInt(4,0);
                pst.setInt(5,0);
                pst.setInt(6,1);
                pst.setInt(7,1);

                pst.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateStandingsOnDefeat(String team){
        System.out.println("Lose: "+  team);

        try {
            String group_name = teamInfo.get(team);
            String sql = "Select * from standings where group_name=? AND team=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, group_name);
            pst.setString(2, team);
            rs = pst.executeQuery();

            if (rs.next()) {
                int match_played = rs.getInt(3);
                int win = rs.getInt(4);
                int lose = rs.getInt(5);
                int draw = rs.getInt(6);
                int pts = rs.getInt(7);

                match_played += 1;
                lose += 1;

                String sql2 = "Update standings SET lose=?, match_played=? where group_name=" + group_name + " AND team="+team;

                pst = conn.prepareStatement(sql2);
                pst.setInt(1,lose);
                pst.setInt(2,match_played);
                pst.execute();
            }
            else{
                String sql2 = "INSERT INTO standings(group_name,team,match_played,win,lose,draw,points) values(?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(sql2);
                pst.setString(1, group_name);
                pst.setString(2, team);
                pst.setInt(3,1);
                pst.setInt(4,0);
                pst.setInt(5,1);
                pst.setInt(6,0);
                pst.setInt(7,0);

                pst.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean validGoals(String goal){
        String regex = "[0-9]+"; //^[1-3]?[0-9]

        Pattern p = Pattern.compile(regex);
        if (goal == null){
            return false;
        }
        Matcher m = p.matcher(goal);

        return m.matches();
    }
}
