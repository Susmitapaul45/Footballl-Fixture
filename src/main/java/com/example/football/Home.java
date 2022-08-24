package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Home {
    private String current = "Home.fxml";

    @FXML
    private Button fixture;
    @FXML
    private Button news;
    @FXML
     private Button teams;
    @FXML
    private Button stats;
    @FXML
    private Button highlights;
    @FXML
    private Button logout;

    @FXML
    protected void onFixtureButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Fixture.fxml");
    }

    @FXML
    protected void onTeamsButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Teams.fxml");
    }

    @FXML
    protected void onNewsButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"News.fxml");
    }

    @FXML
    protected void onStatsButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Stats.fxml");
    }

    @FXML
    protected void onHighlightsButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Highlights.fxml");
    }

    @FXML
    protected void onLogoutButtonCLick() throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"logout.fxml");
    }


}
