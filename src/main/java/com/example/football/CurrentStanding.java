package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CurrentStanding {

    private String current = "CurrentStand.fxml";
    @FXML
    private Button GroupA;

    @FXML
    private Button GroupB;

    @FXML
    private Button GroupC;

    @FXML
    private Button GroupD;

    @FXML
    private Button GroupE;

    @FXML
    private Button GroupF;

    @FXML
    private Button GroupG;

    @FXML
    private Button GroupH;

    @FXML
    private Button Home;

    @FXML
    private Button Logout;

    @FXML
    private Button Back;

    @FXML
    protected void onGroupAButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupAStandings.fxml");

    }

    @FXML
    protected void onGroupBButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupBStandings.fxml");

    }

    @FXML
    protected void onGroupCButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupCStandings.fxml");
    }

    @FXML
    protected void onGroupDButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupDStandings.fxml");
    }

    @FXML
    protected void onGroupEButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupEStandings.fxml");
    }

    @FXML
    protected void onGroupFButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupFStandings.fxml");
    }

    @FXML
    protected void onGroupGButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupGStandings.fxml");
    }

    @FXML
    protected void onGroupHButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "GroupHStandings.fxml");
    }

    @FXML
    protected void onLogoutButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "logout.fxml");
    }

    @FXML
    protected void onHomeButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Home.fxml");
    }

    @FXML
    protected void onBackButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }

    public ObservableList<GroupStandingsData> getStandings(String group_name) {
        ObservableList<GroupStandingsData> list = FXCollections.observableArrayList();

        try {
            HelloApplication h = new HelloApplication();
            Connection conn = h.getDbConnection();
            ResultSet rs = null;
            PreparedStatement pst = null;

            String sql = "Select team, match_played, win, lose, draw, points from standings where group_name=?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, group_name);

            rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new GroupStandingsData(rs.getString(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
