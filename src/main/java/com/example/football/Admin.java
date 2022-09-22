package com.example.football;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class Admin {
    private String current = "Admin.fxml";
    @FXML
    private Button h;

    @FXML
    protected void onScheduleNewMatchButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"ScheduleNewMatch.fxml");
    }
    @FXML
    protected void onUpdateFixtureButtonClick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"UpdateScore.fxml");
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
    public void OnBackButtonClick(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }
}
