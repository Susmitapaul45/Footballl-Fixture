package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Stats {

    private String current = "Stats.fxml";
    @FXML
    private Button MostGoal;
    @FXML
    private Button GoldenGloves;
    @FXML
     private Button GoldenBoot;
    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button  Back;


    @FXML
    protected void onMostGoalButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"MostGoal.fxml");
    }

    @FXML
    protected void onGOldenGlovesButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"GoldenGloves.fxml");
    }


    @FXML
    protected void onGOldenBootButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"GoldenBoot.fxml");
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
