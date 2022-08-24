package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Fixture {

    private String current = "Fixture.fxml";
    @FXML
    private Button CurrentStanding;

    @FXML
    private Button MatchSchedule;
    @FXML
    private Button Groups;
    @FXML
    private Button Logout;
    @FXML
    private Button Home;
    @FXML
    private Button Back;

    @FXML
    protected void onCurrentStandingButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"CurrentStand.fxml");
    }

    @FXML
    protected void onMatchScheduleButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current, "MatchSchedule.fxml");
    }

    @FXML
    protected void onGroupsButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Groups.fxml");
    }

    @FXML
    protected void onLogoutButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"logout.fxml");
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

}
