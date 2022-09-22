package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MatchSchedule {

    private String current = "MatchSchedule.fxml";
    @FXML
    private Button GroupStage;
    @FXML
    private Button RoundOf16;
    @FXML
    private Button  ThirdPlace;
    @FXML
   private Button QuarterFinal;
    @FXML
    private Button SemiFinal;
    @FXML
    private Button Final;
    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;
    @FXML
    protected void onGroupStageButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"GroupStage.fxml");
    }

    @FXML
    protected void onRoundOf16ButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"RoundOf16.fxml");
    }


    @FXML
    protected void onThirdPlaceButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"ThirdPlace.fxml");
    }

    @FXML
    protected void onQuarterFinalButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"QuarterFinal.fxml");
    }
    @FXML
    protected void onSemifinalButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"SemiFinal.fxml");
    }
    @FXML

    protected void onFinalButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Final.fxml");
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
}
