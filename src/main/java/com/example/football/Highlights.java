package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
public class Highlights {

    private String current = "Highlights.fxml";
    @FXML
    private Button Home;
    @FXML
    private Button Logout;

    @FXML
    private Button Back;

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



